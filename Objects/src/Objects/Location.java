package Objects;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by karolsudol on 09/04/15.
 */
public class Location extends Xpath {
    private static final String UrlReqGeoCode = "http://maps.googleapis.com/maps/api/geocode/xml?sensor=false&";
    private static HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
    private String LatStr;
    private String LongStr;
    public void getLongitudeLatitude(String address) {
        try {
            StringBuilder urlBuilder = new StringBuilder(UrlReqGeoCode);
            if (StringUtils.isNotBlank(address)) {
                urlBuilder.append("&address=").append(URLEncoder.encode(address, "UTF-8"));
            }

            final GetMethod getMethod = new GetMethod(urlBuilder.toString());
            try {
                httpClient.executeMethod(getMethod);
                Reader reader = new InputStreamReader(getMethod.getResponseBodyAsStream(), getMethod.getResponseCharSet());

                int data = reader.read();
                char[] buffer = new char[1024];
                Writer writer = new StringWriter();
                while ((data = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, data);
                }

                String result = writer.toString();
                System.out.println(result.toString());

                DocumentBuilderFactory docBuilPath = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = docBuilPath.newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader("<"+writer.toString().trim()));
                Document doc = db.parse(is);

                LatStr = getXpathValue(doc, "//GeocodeResponse/result/geometry/location/lat/text()");
                System.out.println("Latitude:" + LatStr);

                LongStr = getXpathValue(doc,"//GeocodeResponse/result/geometry/location/lng/text()");
                System.out.println("Longitude:" + LongStr);


            } finally {
                getMethod.releaseConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
