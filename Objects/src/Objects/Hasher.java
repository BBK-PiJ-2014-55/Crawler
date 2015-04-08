package Objects;

import java.security.MessageDigest;


/**
 * Created by karolsudol on 08/04/15.
 */
public class Hasher {

    public static String toSha256(String inString) throws Exception {


        MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = inString.toLowerCase();
            md.update(text.getBytes("ASCII"));
            byte[] hash = md.digest();

            StringBuilder sb = new StringBuilder();

            //enhanced loop, array wont be modified
            for (byte b : hash) {
                sb.append(String.format("%02X", b));
            }
            return sb.toString().toUpperCase();



    }
}