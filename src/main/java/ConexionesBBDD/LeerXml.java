package ConexionesBBDD;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class LeerXml {

	
	public void leerXml(String archivoEntrada){
		try {
			File fXmlFile = new File(archivoEntrada);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			doc.getDocumentElement().normalize();
					
			NodeList nList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
			
			NodeList nList2 = doc.getElementsByTagName("empleado");
			 
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
							 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
							
					for (int i =0; i < nList2.getLength() ; i++){
						
						AlojamientoDB alojamiento = new AlojamientoDB();
						
						String Nombre = eElement.getElementsByTagName("documentname").item(i).getTextContent();
						String Descripcion = eElement.getElementsByTagName("turismdescription").item(i).getTextContent();
						int Telefono = Integer.parseInt(eElement.getElementsByTagName("phone").item(i).getTextContent());
						String Direccion = eElement.getElementsByTagName("address").item(i).getTextContent();
						String Email = eElement.getElementsByTagName("tourismemail").item(i).getTextContent();
						String Web = eElement.getElementsByTagName("web").item(i).getTextContent();
						String TipoDeAlojamiento = eElement.getElementsByTagName("lodgingtype").item(i).getTextContent();
						int Capacidad = Integer.parseInt(eElement.getElementsByTagName("capacity").item(i).getTextContent());
						int CodigoPostal = Integer.parseInt(eElement.getElementsByTagName("postalcode").item(i).getTextContent());
						String Longitud = eElement.getElementsByTagName("latwgs84").item(i).getTextContent();
						String Latitud = eElement.getElementsByTagName("longwgs84").item(i).getTextContent();
						
						alojamiento.setNombre(Nombre);
						alojamiento.setDescripcion(Descripcion);
						alojamiento.setTelefono(Telefono);
						alojamiento.setDireccion(Direccion);
						alojamiento.setEmail(Email);
						alojamiento.setWeb(Web);
						alojamiento.setTipoDeAlojamiento(TipoDeAlojamiento);		
						alojamiento.setCapacidad(Capacidad);	
						alojamiento.setCodigoPostal(CodigoPostal);	
						alojamiento.setLongitud(Longitud);	
						alojamiento.setLatitud(Latitud);	
						
				//modelo.get().add(alojamiento);	
						
					}	 
				} 
			}
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }		
	}

}
