// import static HTMLread.*;


import junit.framework.TestCase;

import java.io.BufferedReader;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.IOException;

public class HTMLreadTest extends TestCase {
    private URL TestUrl;
    private BufferedReader TestInputStream;
    private String url = "http://www.yell.com/";



    public HTMLreadTest(){
        try {
            this.TestUrl = new URL(url);
            this.TestInputStream = new BufferedReader(new InputStreamReader(this.TestUrl.openStream()));

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }


    // ******** TESTS for HTMLRead.readUntil() ********
    // method parameters for testReadUntil
    private char a1 = 'a';
    private char a2 = 'b';
    private char a3 = 'c';
    private char a4 = 'c';

    @org.junit.Test
    public void testReadUntil() {
        HTMLread  TestRead = new HTMLread();
        boolean present = TestRead.readUntil(this.TestInputStream,a1,a2);
        assertEquals(true,present);
    }

    @org.junit.Test
    public void testReadUntilCaseSensitive() {
        HTMLread  TestRead = new HTMLread();
        boolean present = TestRead.readUntil(this.TestInputStream,a3,a4);
        assertEquals(true,present);
    }



    // ******* TESTS for HTMLRead.skipSpace() ********
    // method parameters for testSkipSpace
    private char b1 = 'a';
    private char b2 = 'b';
    @org.junit.Test
    public void testSkipSpaceIncWhiteSpace() {
        HTMLread  TestRead = new HTMLread();
        char result = TestRead.skipSpace(this.TestInputStream,b1);
    }

    public void testSkipSpaceExclWhiteSpace() {
        HTMLread  TestRead = new HTMLread();
        char result = TestRead.skipSpace(this.TestInputStream,b2);
    }


    // ******* TESTS for HTMLRead.ReadString() ********
    // method parameters for testReadString
    private char c1 = 'a';
    private char c2 = 'a';
    private char c3 = 'a';
    private char c4 = 'a';
    @org.junit.Test
    public void testReadStringExclNull(){
        HTMLread  TestRead = new HTMLread();
        String resultString = TestRead.readString(this.TestInputStream,c1,c2);
    }

    @org.junit.Test
    public void testReadStringIncNull(){
        HTMLread  TestRead = new HTMLread();
        String resultString = TestRead.readString(this.TestInputStream,c3,c4);
    }




    //    @org.junit.Test
//    public void testReadUntil() throws Exception {
//        InputStream streamA = null;
//        InputStream streamB = null;
//
//
//        try {
//            URL testPageA = new URL("http://bbk.ac.uk");
//            URL testPageB = new URL("http://ucl.ac.uk");
//
//            streamA = testPageA.openStream();
//            streamB = testPageB.openStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        boolean resultA = readUntil();
//        boolean
//
//
//
//
//
//    }


}