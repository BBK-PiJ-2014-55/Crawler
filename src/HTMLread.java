/**
 * Created by karolsudol on 24/03/15.



import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.io.*;
import java.net.*;


// class to accept stream and constructing strings from information read

public class HTMLread {

    String domain = "";

    URL url = new URL(domain);

    HttpURLConnection con = url.openConnection();

    //constructor
    public HTMLread() {
    }

    /**
     * It accepts stream and stops program when the same character is encountered (ignoring case).
     * True if ch1 and ch2 are present;
     *
     * @param con;
     *
     * @param ch1;
     *
     * @param ch2
     *
     *
     * @return boolean present;
     *
     *
     public boolean readUntil(BufferedReader con, char ch1, char ch2){
         boolean present = false;
         try {
             char val = con.read();
             while (val.equalsIgnoreCase != ch1 || val != ch2)
         } try {

         }

         return  present;

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
     *
    public char skipSpace(BufferedReader input, char ch){
        char resultChar = Character.MIN_VALUE;
        return resultChar;

    }

    /**
     * It accepts stream and stops program when the same character is encountered: ch1 ch2.
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
     *
    public String readString(BufferedReader input, char ch1, char ch2 ){
        String resultString = "";
        return resultString;

    }











}
 */
