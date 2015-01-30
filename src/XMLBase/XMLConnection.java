package XMLBase;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLConnection {
	private DocumentBuilder docReader;
	private Document xmldoc;
	
	public XMLConnection() throws ParserConfigurationException {
		docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	}
	
	public void setDocument(String tableName) throws SAXException, IOException, ParserConfigurationException {
		String path = "./XML/" + tableName +".xml";
		xmldoc = docReader.parse(new File(path));
	}
	
	public NodeList query(String tableName, String other) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		NodeList nodeList;
		setDocument(tableName);
		other = "//item";
		XPath xpath = XPathFactory.newInstance().newXPath();
		nodeList = (NodeList) xpath.compile(other).evaluate(xmldoc, XPathConstants.NODESET);
		return nodeList;
		
	}
	
	
	
}
