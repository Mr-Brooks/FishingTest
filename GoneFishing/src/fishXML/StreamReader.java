package fishXML;

import org.w3c.dom.Node;

import fish.Fish;

public interface StreamReader {
	
	
	public void loadFile(String n);
	
	public void writeToXml(Fish a);
	
	public void writeToXml();
	
	public Node getNode(Fish m);
}
