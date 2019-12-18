package TratamientoDatos;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import Modelo.AlojamientoDB;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class LeerXml {

	
	public ArrayList<AlojamientoDB> leerXmlDeAlojamientos(String archivoEntrada){
		
		try {
			File fXmlFile = new File(archivoEntrada);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			ArrayList<AlojamientoDB> alojamientos = new ArrayList<AlojamientoDB>();
			
			doc.getDocumentElement().normalize();			
			NodeList nList2 = doc.getElementsByTagName("row");
			 
			for (int temp = 0; temp < nList2.getLength(); temp++) {
				Node nNode = nList2.item(temp);
							 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					AlojamientoDB alojamiento = new AlojamientoDB();
					
					String Signatura,Nombre,Descripcion,Telefono,Direccion,Email,Web,TipoDeAlojamiento,Longitud,Latitud;
					int Capacidad,CodigoPostal;
					
					try{
						Signatura = eElement.getElementsByTagName("signatura").item(0).getTextContent();
					}catch(Exception e){
						Signatura = String.valueOf(0);
					}
					
					try{
						Nombre = eElement.getElementsByTagName("documentname").item(0).getTextContent();
					}catch(Exception e){
						Nombre = "";
					}
	
					try{
						Descripcion = eElement.getElementsByTagName("turismdescription").item(0).getTextContent();
					}catch(Exception e){
						Descripcion = "";
					}
					
					try{
						Telefono = eElement.getElementsByTagName("phone").item(0).getTextContent();
					}catch(Exception e){
						Telefono = "";
					}
					
					try{
						Direccion = eElement.getElementsByTagName("address").item(0).getTextContent();
					}catch(Exception e){
						Direccion = "";
					}
					
					try{
						Email = eElement.getElementsByTagName("tourismemail").item(0).getTextContent();
					}catch(Exception e){
						Email = "";
					}
					
					try{
						Web = eElement.getElementsByTagName("web").item(0).getTextContent();
					}catch(Exception e){
						Web = "";
					}
					
					try{
						TipoDeAlojamiento = eElement.getElementsByTagName("lodgingtype").item(0).getTextContent();
					}catch(Exception e){
						TipoDeAlojamiento = "";
					}
					
					try{
						Capacidad =  Integer.parseInt(eElement.getElementsByTagName("capacity").item(0).getTextContent());
					}catch(Exception e){
						Capacidad = -1;
					}
					
					try{
						CodigoPostal =  Integer.parseInt(eElement.getElementsByTagName("postalcode").item(0).getTextContent());
					}catch(Exception e){
						CodigoPostal = -1;
					}
					
					try{
						Longitud =  eElement.getElementsByTagName("latwgs84").item(0).getTextContent();
					}catch(Exception e){
						Longitud = "";
					}
					
					try{
						Latitud =  eElement.getElementsByTagName("lonwgs84").item(0).getTextContent();
					}catch(Exception e){
						Latitud = "";
					}						
					
					//System.out.println( i + " Nombre: " + Nombre + " Descripcion:" + Descripcion + " Telefono" + Telefono + " Direccion: " + Direccion + " Email: " + Email + " Web: " + Web + " TipoAlojamiento: " + TipoDeAlojamiento + " Capacidad: " + Capacidad + " CodigoPostal: " + CodigoPostal + " Latitud: " + Latitud + " Longitud: " + Longitud);

					
					alojamiento.setSignatura(Signatura);
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
					
					alojamientos.add(alojamiento);	
				} 
			}
			return alojamientos;
			
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    	return null;
	    }
		
	}

}
