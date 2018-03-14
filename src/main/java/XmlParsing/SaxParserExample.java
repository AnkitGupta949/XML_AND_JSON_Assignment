package XmlParsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParserExample {
    public static void main(String[] args) {

        try {
            File inputFile = new File("src/main/java/XmlParsing/file.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    boolean bfname = false;
    boolean blname = false;
    boolean bcompany = false;
    boolean bloc = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            String empid = attributes.getValue("id");
            System.out.println("Roll No : " +empid );
        } else if (qName.equalsIgnoreCase("firstname")) {
            bfname = true;
        } else if (qName.equalsIgnoreCase("lastname")) {
            blname = true;
        } else if (qName.equalsIgnoreCase("company")) {
            bcompany = true;
        } else if (qName.equalsIgnoreCase("location")) {
            bloc = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("company")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bfname) {
            System.out.println("First Name: " + new String(ch, start, length));
            bfname = false;
        } else if (blname) {
            System.out.println("Last Name: " + new String(ch, start, length));
            blname = false;
        } else if (bcompany) {
            System.out.println("Comapany Name: " + new String(ch, start, length));
            bcompany = false;
        } else if (bloc) {
            System.out.println("Location : " + new String(ch, start, length));
            bloc = false;
        }
    }
}