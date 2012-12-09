package uk.org.downesward.utiliites;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLUtilities {
	public static String serializeDoc(Document doc) 
		throws TransformerException {
		
		StringWriter outText = new StringWriter();
		StreamResult sr = new StreamResult(outText);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = null;

		t = tf.newTransformer();
		t.transform(new DOMSource(doc), sr);

		return outText.toString();
	}
	
	// This method writes a DOM document to a file
	public static void writeXmlFile(Document doc, String filename) 
		throws TransformerFactoryConfigurationError, TransformerException {

	        // Prepare the DOM document for writing
	        Source source = new DOMSource(doc);

	        // Prepare the output file
	        File file = new File(filename);
	        if (!file.canWrite()) {
	        	file.setWritable(true);
	        }
	        Result result = new StreamResult(file);

	        // Write the DOM document to the file
	        Transformer xformer = TransformerFactory.newInstance().newTransformer();
	        xformer.transform(source, result);

	}

	public static Document readXmlFile(String filename) 
		throws SAXException, IOException, ParserConfigurationException {
		
		File fXmlFile = new File(filename);
		if (!fXmlFile.canRead()) {
			fXmlFile.setReadable(true);
		}
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;

		dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		return doc;
	}
	
    public static String getOptionalNode(Element node, String nodeName)
    {
        String result = "";
        Node rclNode = node.getElementsByTagName(nodeName).item(0);
        if (rclNode != null)
        {
        	result = rclNode.getTextContent();
        }
        return result;
    }
}
