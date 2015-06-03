package fishXML;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import fish.Fish;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.stream.StreamResult;  
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class StyleXSL{
	public DocumentBuilderFactory factory;
	public DocumentBuilder builder;
	public Document xmlDoc;
	public String xsltLoc, xmlPath, resultFile;
	public ArrayList<Fish> fishList = new ArrayList<Fish>();
	
	public StyleXSL(String filePath) throws ParserConfigurationException,
	 IOException, SAXException{
		factory =  DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		xmlDoc = builder.parse( ClassLoader.getSystemResourceAsStream(filePath));
	}
	
	public StyleXSL(String xsltPath, String xmlLoc, String result){
		xsltLoc = xsltPath;
		xmlPath = xmlLoc;
		resultFile = result;
	}
	
	public void readXml(){
		
		NodeList nodeList = xmlDoc.getDocumentElement().getChildNodes();

	    for (int i = 0; i < nodeList.getLength(); i++) {
	      Node node = nodeList.item(i);
	      if (node instanceof Element) {
	    	  //
	      }
	    }
	}
	
	public void transformXML(){
		TransformerFactory tFactory = TransformerFactory.newInstance();  
        try {  
            Transformer transformer =  
                tFactory.newTransformer(new StreamSource(new File(xsltLoc)));  
  
            transformer.transform(new StreamSource(new File(xmlPath)),  
                                  new StreamResult(new File(resultFile)));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
	}
	

}
