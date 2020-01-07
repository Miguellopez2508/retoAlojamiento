package TratamientoDatos;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource ;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Md5Xml {
	
	public void pasarXmlAString(String xmlDocument)
	{	
		File file = new File(xmlDocument);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = dBuilder.parse(file);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer transformer;
	    try {
	        transformer = tf.newTransformer();
	         
	        // Uncomment if you do not require XML declaration
	        // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	         
	        //A character stream that collects its output in a string buffer, 
	        //which can then be used to construct a string.
	        StringWriter writer = new StringWriter();
	 
	        //transform document to string 
	        transformer.transform(new DOMSource(doc), new StreamResult(writer));
	 
	        String xmlString = writer.getBuffer().toString();   
	        System.out.println(xmlString);                     
	    } 
	    catch (TransformerException e) 
	    {
	        e.printStackTrace();
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
	}
	
	
}
