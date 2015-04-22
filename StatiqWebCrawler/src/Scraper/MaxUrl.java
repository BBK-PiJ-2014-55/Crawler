package Scraper;

import Interfaces.GetResultsNo;
import org.w3c.dom.Document;

/**
 * Created by karolsudol on 22/04/15.
 */
public class MaxUrl implements GetResultsNo {

    private String resultsNoXpath = "";
    private String strResultsNo;
    private int maxResults = Integer.parseInt(strResultsNo);
    public int maxUrl = maxResults/10;


    public int getResultsNo (Document startUrl){

        try {
            while (resultsNoXpath != null){
               strResultsNo = Xpath.getXpathValue(startUrl,resultsNoXpath);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        } return maxResults;
    }

}
