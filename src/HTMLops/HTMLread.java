package HTMLops; /**
 * Created by karolsudol on 24/03/15.
 */

import Interfaces.HTMLinput;

import java.io.BufferedReader;
import java.io.IOException;


// class to accept stream and constructing strings from information read

public class HTMLread implements HTMLinput {

    /**
     * input bytes stream as int to check if empty
     */
    private int inStreamCh;
    private char presetCharRead;
    private char c1;
    private char c2;


    //constructor
    public HTMLread() { }


     public boolean readUntil(BufferedReader con, char ch1, char ch2){


         boolean present = false;

         try {

             //accept input and converts to lower case
             inStreamCh = Character.toLowerCase(con.read());
             c1 = Character.toLowerCase(ch1);
             c2 = Character.toLowerCase(ch2);
             while ((inStreamCh != -1 )){
                 if (inStreamCh == c1) {return present;}
                 if (inStreamCh == c2) { return present;}
                 }
         } catch (IOException ex) {
             ex.printStackTrace();
         }

           return  present;
     }



    public char skipSpace(BufferedReader con, char ch){

        char result = Character.MIN_VALUE;

        try {
            // accepts input
            inStreamCh = con.read();
            while (inStreamCh != -1){
                presetCharRead = (char) inStreamCh;
                if (!Character.isWhitespace(ch)){
                    if (inStreamCh == ch) {
                        break;
                    } else {
                        result = presetCharRead;
                    }

                }
            }


        } catch (IOException ex){
            ex.printStackTrace();
        }

        return result;
    }




    public String readString(BufferedReader con, char ch1, char ch2 ){

        StringBuilder resultString = new StringBuilder();


        try {
            inStreamCh = con.read();
            while (inStreamCh != -1){
                presetCharRead = (char) inStreamCh;

                if (presetCharRead == ch1){
                    return resultString.toString();

                } else {
                    break;
                }

            }

        } catch (IOException ex){
            ex.printStackTrace();
        }

        return null;

    }


}

