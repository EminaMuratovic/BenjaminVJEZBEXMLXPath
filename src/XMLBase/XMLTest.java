package XMLBase;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Shared.Article;
import XMLBase.XMLConnection;

public class XMLTest {
	
	private static boolean testArticleConstructor() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document xmldoc = docReader.parse(new File("./XML/Articles.xml"));
		Node testItem = xmldoc.getElementsByTagName("item").item(0);
		Article testArticle = new Article(testItem);
		if(testArticle.getId() != 1)
			return false;
		if(testArticle.getPubDate() != 0)
			return false;
		if(testArticle.getAuthorID() != 1)
			return false;

		return true;
	}
	
	public static boolean test(String tableName, String other) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
		XMLConnection connection = new XMLConnection();
		NodeList nodeList = connection.query(tableName, other);
		if(nodeList instanceof NodeList == false)
			return false;

		Node testItem = nodeList.item(0);
		Article testArticle = new Article(testItem);
		if(testArticle.getId() != 1)
			return false;
		if(testArticle.getPubDate() != 0)
			return false;
		if(testArticle.getAuthorID() != 1)
			return false;

		return true;
		
	}
	
	
	public static void main(String[] args) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
//		try {
//			if(testArticleConstructor() == false)
//				System.err.println("Test article constructor failed! ");
//			else
//				System.out.println("Test article constructor did not fail!  ");
//		} catch (ParserConfigurationException | SAXException | IOException e) {
//			System.err.println("Article constructor test failed! ");
//			
//		}
		
		if(test("Article", "//item"))
			System.out.println("It works.");
		else
			System.out.println("It doesn't work");
		
			
	}

}
