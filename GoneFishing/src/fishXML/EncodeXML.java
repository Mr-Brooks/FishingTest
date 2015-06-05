package fishXML;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fish.Fish;

public class EncodeXML implements StreamReader {
	public XMLEncoder encode;
	public String file;
	public DocumentBuilderFactory xmlFactory;
	public DocumentBuilder xmlBuilder;
	public Document doc;
	public Element mainRootElement;
	
	
	public EncodeXML(){
		
	}
	
	@Override
	public void loadFile(String filename){
		file = filename;
	}
	
	public void createEncoder(){
		try {
			encode = new XMLEncoder(new BufferedOutputStream( 
					new FileOutputStream(file)));
			xmlFactory = DocumentBuilderFactory.newInstance();
			xmlBuilder = xmlFactory.newDocumentBuilder();
            doc = xmlBuilder.newDocument();
            
            mainRootElement = doc.createElementNS("", "Test");
            doc.appendChild(mainRootElement);
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void writeToXml(Fish fish){
		
        mainRootElement.appendChild(getNode(fish));
        
        Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			//transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
	        StreamResult console = new StreamResult(file);
            transformer.transform(source, console);
 
            System.out.println("\nXML DOM Created Successfully..");
		} catch (TransformerConfigurationException
				| TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeXmlFile(String filename){
		file = filename;
	}

	@Override
	public void writeToXml() {
		
	}

	@Override
	public Node getNode(Fish m) {
		Element xmlNode1 = doc.createElement("Fish");
        //xmlNode.setAttribute("id", id);
        xmlNode1.appendChild(getFishElements(doc, xmlNode1, "Name", m.returnFullName()));
        xmlNode1.appendChild(getFishElements(doc, xmlNode1, "DOB",  m.returnDate().toString()));
        xmlNode1.appendChild(getFishElements(doc, xmlNode1, "Type", m.returnType().toString()));
        Element xmlNode2 = doc.createElement("Address");
        xmlNode2.setAttribute("home", m.returnHome().toString());
        xmlNode2.appendChild(getFishElements(doc, xmlNode2, "Ocean", m.returnOcean()));
        xmlNode2.appendChild(getFishElements(doc, xmlNode2, "Reef", m.returnReef()));
        String depth = m.returnDepth() + " ft";
        xmlNode2.appendChild(getFishElements(doc, xmlNode2, "Depth", depth));
        
        xmlNode1.appendChild(xmlNode2);
        
        
        return xmlNode1;
	}
	
	private Node getFishElements(Document dc, Element parentNode, String tag, String value){
		Element node = doc.createElement(tag);
        node.appendChild(doc.createTextNode(value));
        return node;
	}
}
