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

    public Document getDocument() {
        return document;
    }

    public int getPostcodeParseStatus() {
        return postcodeParseStatus;
    }

    public int getAnchorParseStatus() {
        return anchorParseStatus;
    }

    public String getWebPageHash() {
        return webPageHash;
    }

    public Anchor getAnchor() {
        return anchor;
    }

    /**
     *
     * crawler method (constructor)
     *
     * @param anchor
     */
    public WebPage(Anchor anchor) throws Exception {
        this.anchor = anchor;
        this.webPageHash = Hasher.toSha256(anchor.getAnchorHash() + CommonFunc.getTimestamp().toString());
        this.anchorParseStatus = 0;
        this.postcodeParseStatus = 0;
    }

    public void getWEbDocument(){


        try {
            document = Jsoup.connect(anchor.getAnchorUrl()).get();
            Elements links = document.select("a");
            for (Element e: links){
                System.out.println(e.attr("abs:href"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
