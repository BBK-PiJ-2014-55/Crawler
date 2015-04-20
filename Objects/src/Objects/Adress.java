package Objects;

/**
 * Created by karolsudol on 13/04/15.
 */


import org.w3c.dom.Document;

/**
 * Extract adress from the html
 */

public class Adress  {
    private String adress;

    public void getAdress(String page){

        String XpathAdress = "//*[@id=\"content\"]/div/div[1]/div[6]/div[3]/div[2]/div[2]/div/div[3]/a/span/span[1]";

        adress = getXpathValue(page,);






    }
}
