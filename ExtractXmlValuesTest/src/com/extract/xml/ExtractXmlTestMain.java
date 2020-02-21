package com.extract.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ExtractXmlTestMain {

	public static void main(String[] args) {
		ExtractXmlTestMain xmlTest = new ExtractXmlTestMain();
		Document xmlDomDocument = xmlTest.getXmlDomDocument();
		xmlTest.printElements(xmlDomDocument);
	}


	/**
	 * Get the input_document.xml file and Parse into DOM Document for processing.
	 * @return Document
	 */
	private Document getXmlDomDocument() {
		try {
			File payload = new File("./src/com/extract/xml/input_document.xml");
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
	 * Print RefText Elements where RefCode attribute is equal to (MWB or TRV or CAR)
	 * @param doc
	 */
	public void printElements(Document doc) {
		try {
			NodeList nodeList = doc.getElementsByTagName("Reference");

			List<String> refTextValues = new ArrayList<>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String refCode = element.getAttribute("RefCode");
					String refText = element.getElementsByTagName("RefText").item(0).getTextContent();

					if(refCode.equals("MWB") || refCode.equals("TRV") || refCode.equals("CAR")) {
						refTextValues.add(refText);
					}
				}
			}

			System.out.println("RefText Elements : " + refTextValues);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
