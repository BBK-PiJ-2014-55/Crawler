package ObectTest;

import Objects.Anchor;
import Objects.Domain;
import Objects.WebPage;
import org.junit.*;

public class ObjectTest {


    @org.junit.Test
    public void LoadWebPage(){
        Domain domain = new Domain("1234-123","http://jsoup.org");
        Anchor anchor = new Anchor(domain,"1234-123","http://jsoup.org");
        WebPage webPage = new WebPage(anchor);
        webPage.getWEbDocument();



        Assert.assertTrue("result", webPage.getDocument() != null);

    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
}
