package Interfaces;

import org.w3c.dom.Document;

/**
 * Created by karolsudol on 21/04/15.
 */
public interface GetAddress {

    /**
     * receives HTML and returns address
     *
     * @param html
     *
     */
    public String getAddress (Document html);
}
