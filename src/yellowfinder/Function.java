package yellowfinder;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Function {
	
	static void takeFile(File file) throws SAXException, IOException, ParserConfigurationException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();

		NodeList yellowlist = doc.getElementsByTagName("Stream");
		
		 for (int s = 0; s < yellowlist.getLength(); s++) {

			    Node yellow = yellowlist.item(s);
			    System.out.println(yellow);
			    
			    if (yellow.getNodeType() == Node.ELEMENT_NODE) {
			  
			      Element fstElmnt = (Element) yellow;
			      Node fstNmElmntLst = (Node) fstElmnt.getElementsByTagName("Yellow flag state 0-&gt;1");
			      System.out.println(fstNmElmntLst);
			    }
		 }
	} 
			  }


