package com.abm.resources;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParserUtils {
	
	public XmlParserUtils() {}

	/**
	 * Get the payload.xml file and Parse into DOM Document for processing.
	 * @return Document
	 */
	private Document getXmlDomDocument() {
		try {		
			File payload = new File(getClass().getClassLoader().getResource("payload.xml").getFile());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(payload);
			doc.getDocumentElement().normalize();
			return doc; 
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Return true if 'Command' attribute is equal to 'DEFAULT'
	 * @return boolean
	 */
	public boolean isCommandDefault() {
		Document doc = getXmlDomDocument();
		NodeList nodeList = doc.getElementsByTagName("Declaration");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;

				if(element.getAttribute("Command").equals("DEFAULT")) {
					return true;
				}
			}
		}
		return false;	
	}

	/**
	 * Return true if 'SiteID' element is equal to 'DUB'
	 * @return boolean
	 */
	public boolean isSiteIdDub() {
		Document doc = getXmlDomDocument();
		NodeList nodeList = doc.getElementsByTagName("Declaration");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;

				if(element.getElementsByTagName("SiteID").item(0).getTextContent().equals("DUB")) {
					return true;
				}
			}
		}
		return false;
	}

}


