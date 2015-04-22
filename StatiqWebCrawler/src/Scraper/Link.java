package Scraper;

import Interfaces.GetLinks;
import org.w3c.dom.Document;

/**
 * Created by karolsudol on 22/04/15.
 */
public class Link implements GetLinks {

    private String links;
    private String xPathUrl = "//*[@id=\"bottomPageNumbers\"]/div/a[2]";

    public String getLinks (Document htmlDoc){

        try {
            while (htmlDoc != null){
                links = Xpath.getXpathValue(htmlDoc,xPathUrl);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return links;
   }

}
