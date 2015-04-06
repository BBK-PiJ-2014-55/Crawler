package Objects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by karolsudol on 06/04/15.
 */
public class WebPage {

    private Anchor anchor;
    private String webPageHash;
    private int anchorParseStatus;
    private int postcodeParseStatus;
    private Document document;

    /**
     *
     * crawler method (constructor)
     *
     * @param anchor
     */
    public WebPage(Anchor anchor) {
        this.anchor = anchor;
    }

    private void getWEbDocument(){


        try {
            document = Jsoup.connect(anchor.getAnchorUrl()).get();
            Elements links = doc.select("a");
            for (Element e: links){
                System.out.println(e.attr("abs:href"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
