package fishXML;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import fish.Fish;

public class EncodeXML {
	public XMLEncoder encode;
	public String file;
	
	public EncodeXML(String filename){
		file = filename;
	}
	
	public void createEncoder(){
		try {
			encode = new XMLEncoder(new BufferedOutputStream( 
					new FileOutputStream(file)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeToXml(Fish fish){
		encode.writeObject(fish);
	}
	
	public void changeXmlFile(String filename){
		file = filename;
	}
}
