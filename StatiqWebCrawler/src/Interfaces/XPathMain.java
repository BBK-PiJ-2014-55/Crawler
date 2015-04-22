package Interfaces;

import org.w3c.dom.Document;

/**
 * Created by karolsudol on 21/04/15.
 */
public interface XPathMain {

    /**
     * receives document and xpath item,
     * returns desired object
     *
     * @param doc
     * @param strXpath
     */
    public String getXpathValue (Document doc, String strXpath);

}
