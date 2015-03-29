import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static HTMLread.*;

public class HTMLreadTest {


    @org.junit.Test
    public void testReadUntil() throws Exception {
        InputStream streamA = null;
        InputStream streamB = null;


        try {
            URL testPageA = new URL("http://bbk.ac.uk");
            URL testPageB = new URL("http://ucl.ac.uk");

            streamA = testPageA.openStream();
            streamB = testPageB.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean resultA = readUntil();
        boolean 





    }



    @org.junit.Test
    public void testSkipSpace() throws Exception {

    }

    @org.junit.Test
    public void testReadString() throws Exception {

    }
}