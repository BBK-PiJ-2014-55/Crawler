/**
 * Created by karolsudol on 24/03/15.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;


public class WebCrawler {

//    private LinkedList<String[]> tempTable;

  //  public void crawl(URL ulr, String database){

    //}




    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("http://en.jsoup.org/").get();
            Elements links = doc.select("a");
            for (Element e: links){
                System.out.println(e.attr("abs:href"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

