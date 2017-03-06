package com.karimero;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XmlFileWriter {

	public void write(Document dom, String path){
		try (BufferedOutputStream bufferedOutputStream
				= new BufferedOutputStream(new FileOutputStream(new File(path)));) {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty("method", "xml");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "no");
			transformer.transform(new DOMSource(dom), new StreamResult(bufferedOutputStream));
		} catch (TransformerFactoryConfigurationError | IOException | TransformerException e) {
			e.printStackTrace();
		} 
	}
}
