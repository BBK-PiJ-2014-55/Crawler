package Scraper;

import Interfaces.GetLocation;
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
public class Location implements GetLocation {

    private static final String UrlReqGeoCode = "http://maps.googleapis.com/maps/api/geocode/xml?sensor=false&";
    private static HttpClient httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
    private String latStr;
    private String longStr;
    private Float latFloat;
    private Float longFloat;
    private String latXpath = "//GeocodeResponse/result/geometry/location/lat/text()";
    private String longXpath = "//GeocodeResponse/result/geometry/location/lng/text()";

    public Float[] getLongitudeLatitude(String address) {
        try {
            StringBuilder urlBuilder = new StringBuilder(UrlReqGeoCode);
            if (StringUtils.isNotBlank(address)) {
                urlBuilder.append("&address=").append(URLEncoder.encode(address, "UTF-8"));
            }

            final GetMethod getMethod = new GetMethod(urlBuilder.toString());
            try {
                httpClient.executeMethod(getMethod);
                Reader reader = new InputStreamReader(getMethod.getResponseBodyAsStream(), getMethod.getResponseCharSet());

                int data;  //reader.read();
                char[] buffer = new char[1024];
                Writer writer = new StringWriter();
                while ((data = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, data);
                }

                String result = writer.toString();
                System.out.println(result.toString());

                DocumentBuilderFactory docBuildPath = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = docBuildPath.newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader("<"+writer.toString().trim()));
                Document doc = db.parse(is);

                latStr = Xpath.getXpathValue(doc, latXpath);
                latFloat = Float.parseFloat(latStr);
                //System.out.println("Latitude:" + latStr);

                longStr = Xpath.getXpathValue(doc,longXpath);
                longFloat = Float.parseFloat(longStr);
                //System.out.println("Longitude:" + longStr);


            } finally {
                getMethod.releaseConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return new Float[] {latFloat, longFloat};
    }

}
