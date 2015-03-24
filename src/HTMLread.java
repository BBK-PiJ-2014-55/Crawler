/**
 * Created by karolsudol on 24/03/15.
 */
public interface HTMLread {


    /**
     * This method accepts an instance of an InputStream and two char’s as parameters,
     * and consumes characters from the InputStream.
     * It stops when a character that is the same as ch1 or ch2 is encountered, ignoring case.
     * If the character is the same as ch1 the value true is returned; otherwise, false is returned.
     *
     * @param con
     * @param ch1
     * @param ch2
     *
     *@return TRUE
     *@return FALSE
     *
     */
     public void readUntil();


    /**
     * Accepts an instance of an InputStream.
     * It consumes up to and including the first non-whitespace character from the InputStream or up to and including ch.
     * 
     *@param ch
     */
    public void skipSpace();




}
