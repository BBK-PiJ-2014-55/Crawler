package Objects;

import java.util.*;
import java.io.*;
import java.lang.*;

import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.services.bigquery.*;
import com.google.api.services.bigquery.model.*;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.*;
import com.google.api.client.json.*;
import com.google.api.client.json.jackson.*;
import com.google.api.client.auth.oauth2.*;
import com.google.api.client.extensions.appengine.http.*;
import com.google.api.client.extensions.appengine.auth.oauth2.*;


/**
 * Created by karolsudol on 17/04/15.
 */
public class BigQuery {

    public static TableSchema generateSchema() {
        List<TableFieldSchema> schemaList = new ArrayList<TableFieldSchema>();
        schemaList.add(new TableFieldSchema().setName("FirstName")
                .setType("STRING"));
        schemaList.add(new TableFieldSchema().setName("LastName")
                .setType("STRING"));
        schemaList.add(new TableFieldSchema().setName("Id")
                .setType("STRING"));

        TableSchema schema = new TableSchema();
        schema.setFields(schemaList);

        return schema;
    }

    public static String generateData() {
        String data = "FirstName,LastName,Id\n"
                + "Adam,Bell,2513\n"
                + "Felicia,Mullins,7234\n"
                + "Jennifer,Devore,1355\n"
                + "George,Cox,5541\n"
                + "Daniel,Ward,8050\n";

        return data;
    }

    public static void main(String[] args) {
        final String ACCOUNT_ID = "";
        final String KEY_FILE   = "";
        final String PROJECT_ID = "";
        final String DATASET_ID = "Test";
        final String TABLE_ID   = "Test";

        try {
            HttpTransport httpTransport = new NetHttpTransport();
            JsonFactory jsonFactory = new JacksonFactory();

            File keyFile = new File(KEY_FILE);

            GoogleCredential.Builder credBuilder = new GoogleCredential.Builder();
            credBuilder.setJsonFactory(jsonFactory);
            credBuilder.setTransport(httpTransport);
            credBuilder.setServiceAccountId(ACCOUNT_ID);
            credBuilder.setServiceAccountPrivateKeyFromP12File(keyFile);
            credBuilder.setServiceAccountScopes(Collections.singleton(BigqueryScopes.BIGQUERY));

            GoogleCredential credentials = credBuilder.build();

            Bigquery.Builder serviceBuilder =
                    new Bigquery.Builder(httpTransport,
                            jsonFactory,
                            credentials);


            Bigquery service = serviceBuilder.build();

            if (service == null || service.jobs() == null) {
                throw new Exception("Service is null");
            }

            DatasetReference datasetRef = new DatasetReference();
            datasetRef.setProjectId(PROJECT_ID);
            datasetRef.setDatasetId(DATASET_ID);

            Dataset outputDataset = new Dataset();
            outputDataset.setDatasetReference(datasetRef);

            Dataset dataset = service.datasets().insert(PROJECT_ID,
                    outputDataset).execute();

            TableReference destinationTable = new TableReference();
            destinationTable.setProjectId(PROJECT_ID);
            destinationTable.setDatasetId(DATASET_ID);
            destinationTable.setTableId(TABLE_ID);

            JobConfigurationLoad jobLoad = new JobConfigurationLoad();
            jobLoad.setSchema(generateSchema());
            jobLoad.setSourceFormat("CSV");
            jobLoad.setDestinationTable(destinationTable);
            jobLoad.setCreateDisposition("CREATE_IF_NEEDED");

            JobConfiguration jobConfig = new JobConfiguration();
            jobConfig.setLoad(jobLoad);

            JobReference jobRef = new JobReference();
            jobRef.setProjectId(PROJECT_ID);

            Job outputJob = new Job();
            outputJob.setConfiguration(jobConfig);
            outputJob.setJobReference(jobRef);

            String data = generateData();

            ByteArrayContent contents = new ByteArrayContent("application/octet-stream" , data.getBytes());

            Job job = service.jobs().insert(PROJECT_ID,
                    outputJob,
                    contents).execute();

            if (job == null) {
                throw new Exception("Job is null");
            }

            while (true) {
                String status = job.getStatus().getState();

                if (status != null || ("DONE").equalsIgnoreCase(status)) {
                    break;
                }

                Thread.sleep(1000);
            }

            ErrorProto errorResult = job.getStatus().getErrorResult();

            if (errorResult != null) {
                throw new Exception("Error running job: " + errorResult);
            }
        }
        catch (Exception ex) {
            System.out.println("Caught exception: " + ex + "\n");
            ex.printStackTrace();

            System.exit(1);
        }

        System.exit(0);
    }

}
