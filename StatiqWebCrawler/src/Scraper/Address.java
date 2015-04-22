package Scraper;

import Interfaces.GetAddress;
import org.w3c.dom.Document;

/**
 * Created by karolsudol on 21/04/15.
 */
public class Address implements GetAddress {

    private String fullAddress;

    private String xpathStreet = "//*[@id=\"content\"]/div/div[1]/div[5]/div[3]/div[2]/div[2]/div/div[3]/a/span";
    private String xpathCity = "";
    private String xpathPostCode = "";

    private String street;
    private String city;
    private String postalCode;

    public String getAddress (Document html) {

        try {
            while (html != null){
                street = Xpath.getXpathValue(html,xpathStreet);

            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return fullAddress;
    }

}
