package Shared;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Article {
	private int id;
	private String title;
	private String content;
	private int pubDate;
	private int authorID;

	public Article(int id, String title, String content, int pubDate,
			int authorID) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.pubDate = pubDate;
		this.authorID = authorID;
	}

	public Article(Node node) {
		if (node instanceof Element) {
			Element nodeEl = (Element) node;
			id = Integer.parseInt(nodeEl.getAttribute("id"));
			NodeList nodeChildren = nodeEl.getChildNodes();
			for (int i = 0; i < nodeChildren.getLength(); i++) {
				Node childNode = nodeChildren.item(i);
				if (childNode instanceof Element) {
					Element childNodeEl = (Element) childNode;
					if (childNodeEl.getTagName().equals("title"))
						this.title = childNodeEl.getTextContent();
					if (childNodeEl.getTagName().equals("clanak"))
						this.content = childNodeEl.getTextContent();
					if (childNodeEl.getTagName().equals("autor"))
						this.authorID = Integer.parseInt(childNodeEl
								.getAttribute("id"));
					if (childNodeEl.getTagName().equals("pubDate"))
						this.pubDate = Integer.parseInt(childNodeEl
								.getTextContent());

				}
				
			}
		}
//		else {
//			System.err.println("Not instance of Element!");
//		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPubDate() {
		return pubDate;
	}

	public void setPubDate(int pubDate) {
		this.pubDate = pubDate;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

}
