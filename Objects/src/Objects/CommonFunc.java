package Objects;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by karolsudol on 08/04/15.
 */
public class CommonFunc {

    public static Timestamp getTimestamp(){
        java.util.Date date = new Date();
        return new Timestamp(date.getTime());

    }
}
