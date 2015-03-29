/**
 * Created by karolsudol on 24/03/15.
 */

import java.io.InputStream;

// class to accept stream and constructing strings from information read

public class HTMLread {

    //position of read character
    private int charRead;

    //constructor
    public HTMLread() {
    }

    /**
     * It accepts stream and stops program when a the same character is encountered (ignoring case).
     * True if ch1 and ch2 are present;
     *
     * @param con;
     *
     * @param ch1;
     *
     * @param ch2;
     *
     *
     * @return boolean found;
     *
     */
     public boolean readUntil(InputStream con, char ch1, char ch2){
         boolean found = false;
         return  found;

     }


    /**
     * It accepts input and stops program until non-whitespace character or ch (including) and
     * returns smallest value of char, otherwise returns non-whitespace char that was read.
     *
     * @param input;
     *
     * @param ch;
     *
     * @return resultChar;
     *
     */
    public char skipSpace(InputStream input, char ch){
        char resultChar = Character.MIN_VALUE;
        return resultChar;

    }

    /**
     * It accepts stream and stops program when a the same character is encountered: ch1 ch2.
     * If true returns: ordered characters from input as String.
     *
     * @param input;
     *
     * @param ch1;
     *
     * @param ch2;
     *
     * @return result;
     *
     */
    public String readString(InputStream input, char ch1, char ch2 ){
        String result = "";
        return result;

    }











}
