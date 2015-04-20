package Objects;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.xpath.*;

/**
 * Created by karolsudol on 13/04/15.
 */

public class Xpath {

    public static String getXpathValue(Document doc, String strXpath) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression ex = xPath.compile(strXpath);
        String resultData = null;
        Object res = ex.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) res;
        for (int i = 0; i < nodes.getLength(); i++) {
            resultData = nodes.item(i).getNodeValue();
        }
        return resultData;


    }
}
