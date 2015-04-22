package Interfaces;

import org.w3c.dom.Document;

/**
 * Created by karolsudol on 21/04/15.
 */
public interface GetLinks {

    /**
     * receives HTML document and returns href links to anchor pages
     *
     * @param htmlDoc
     */
    public String getLinks (Document htmlDoc);
}
