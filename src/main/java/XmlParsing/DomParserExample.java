package XmlParsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParserExample {

    public static void main(String[] args) {

        try {
            File inputFile = new File("src/main/java/XmlParsing/file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			/*if (doc.getDocumentElement().hasChildNodes()) {
				// loop again if has child nodes
				System.out.println(doc.getDocumentElement().getChildNodes().getLength());
			}*/

            NodeList nList = doc.getElementsByTagName("employee");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("employee id : " + eElement.getAttribute("id"));
                    System.out.println(
                            "First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println(
                            "Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println(
                            "Company : " + eElement.getElementsByTagName("company").item(0).getTextContent());
                    System.out.println("Location : " + eElement.getElementsByTagName("location").item(0).getTextContent());


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
