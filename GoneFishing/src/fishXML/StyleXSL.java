package fishXML;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import fish.Fish;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;  
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class StyleXSL implements StreamReader{
	public DocumentBuilderFactory factory;
	public DocumentBuilder builder;
	public Document xmlDoc;
	public String xmlPath;
	public File xmlFile;
	public String xslLoc;
	public ArrayList<Fish> fishList = new ArrayList<Fish>();
	private String filePath;
	
	public StyleXSL(){
		
	}
	
	public void setStyle(String Loc, String xmlLoc){
		xslLoc = Loc;
		xmlFile = new File(xmlLoc);
	}
	@Override
	public void loadFile(String file){
		filePath = file;
		try {
			getXml();
		} catch (ParserConfigurationException | IOException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getXml() throws ParserConfigurationException,
	 IOException, SAXException{
		factory =  DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		xmlDoc = factory.newDocumentBuilder().parse(filePath);
	}
	
	public Fish readXml(){
		//Add Implementation to read xml and convert to new Fish object
		return null;
	}
	
	@Override
	public void writeToXml(){
		TransformerFactory factory = TransformerFactory.newInstance();
		
		try {
			Templates template = factory.newTemplates(new StreamSource(new FileInputStream(xslLoc)));
			Transformer xformer = template.newTransformer();
			xformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			Source source = new StreamSource(new FileInputStream(filePath));
			Result result = new DOMResult(xmlDoc);
			//StreamResult console = new StreamResult(xmlFile);
			StreamResult console = new StreamResult(System.out);
			
			xformer.transform(source, console);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void writeToXml(Fish a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Node getNode(Fish m) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
