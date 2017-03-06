package com.karimero;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlFileWriterTest {

	public static void main(String[] args) throws Exception{
		new XmlFileWriter().write(createTestDom(), "./dst.xml");
	}
	
	private static Document createTestDom() throws Exception{
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document dom = b.newDocument();
		
		
		Element root = (Element) dom.appendChild(dom.createElement("DOCUMENT"));
		root.appendChild(dom.createElement("DATA"))
			.appendChild(dom.createElement("TEXT001")).setTextContent("aiueo");
		
		return dom;
	}
}
