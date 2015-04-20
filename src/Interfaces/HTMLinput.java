package Interfaces;

import java.io.BufferedReader;

/**
 * Created by karolsudol on 20/04/15.
 */
public interface HTMLinput {

    /**
     * It accepts stream and stops program when the same character is encountered (ignoring case).
     * True if ch1 and ch2 are present;
     *
     * @param con
     *
     * @param ch1
     *
     * @param ch2
     *
     *
     * @return boolean present;
     *
     */
    public boolean readUntil(BufferedReader con, char ch1, char ch2);



    /**
     * It accepts input and stops program until non-whitespace character or ch (including) and
     * returns smallest value of char, otherwise returns non-whitespace char that was read.
     *
     * @param input
     *
     * @param ch
     *
     * @return resultChar
     *
     */
    public char skipSpace(BufferedReader input, char ch);



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
     */
    public String readString(BufferedReader input, char ch1, char ch2 );









}
