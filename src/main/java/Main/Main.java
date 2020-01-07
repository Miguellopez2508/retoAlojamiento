package Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ConexionesBBDD.ControladorAlojamiento;
import ConexionesBBDD.SessionFactoryUtil;
import Modelo.AlojamientoDB;
import TratamientoDatos.DescargaXml;
import TratamientoDatos.LeerXml;
import TratamientoDatos.Md5Xml;
import TratamientoDatos.TratarJson;

public class Main {

	public static void main(String[] args) {
		
		LeerXml leerXml = new LeerXml();
		DescargaXml descargarXml = new DescargaXml();
		TratarJson jsonador = new TratarJson();
		  
		Md5Xml md5 = new Md5Xml();
		md5.pasarXmlAString("albergues.xml");
				
		SessionFactoryUtil sesion = SessionFactoryUtil.getInstance();
		Session session = sesion.factory.openSession();
		
		descargarXml.cogerRuta();
		
		String campings = System.getProperty("user.dir") + "\\campings.xml";
		String alojamientosRurales = System.getProperty("user.dir") + "\\alojamientosRurales.xml";
		String albergues = System.getProperty("user.dir") + "\\albergues.xml";
		
		ArrayList<AlojamientoDB> ArrayCampings =  leerXml.leerXmlDeAlojamientos(campings);
		ArrayList<AlojamientoDB> ArrayAlojamientosRurales =  leerXml.leerXmlDeAlojamientos(alojamientosRurales);
		ArrayList<AlojamientoDB> ArrayAlbergues =  leerXml.leerXmlDeAlojamientos(albergues);
		
		System.out.println("Borrando tablas...");
		String hql = "delete from Modelo.AlojamientoDB";
		Query query = session.createQuery(hql);	
		query.executeUpdate();
		System.out.println("Borradas\n");
		
//		ControladorUsuarios miControlador1 = new ControladorUsuarios();
//		miControlador1.addUsuarioDB("fsdfs", "asda", "dasf", "ads");
		
		ControladorAlojamiento miControlador2 = new ControladorAlojamiento();
		
		System.out.println("Cargando datos...");

		for (AlojamientoDB campingss : ArrayCampings) {
			miControlador2.addAlojamientoBD(campingss.getSignatura(), campingss.getNombre(), campingss.getDescripcion(), campingss.getTelefono(), campingss.getDireccion(), campingss.getEmail(), campingss.getWeb(), campingss.getTipoDeAlojamiento(), campingss.getCapacidad(), campingss.getCodigoPostal(), campingss.getLongitud(), campingss.getLatitud(), campingss.getMunicipio(), campingss.getTerritorio());	
		}	
		for (AlojamientoDB campingss : ArrayAlojamientosRurales) {
			miControlador2.addAlojamientoBD(campingss.getSignatura(), campingss.getNombre(), campingss.getDescripcion(), campingss.getTelefono(), campingss.getDireccion(), campingss.getEmail(), campingss.getWeb(), campingss.getTipoDeAlojamiento(), campingss.getCapacidad(), campingss.getCodigoPostal(), campingss.getLongitud(), campingss.getLatitud(), campingss.getMunicipio(), campingss.getTerritorio());
		}	
		for (AlojamientoDB campingss : ArrayAlbergues) {
			miControlador2.addAlojamientoBD(campingss.getSignatura(), campingss.getNombre(), campingss.getDescripcion(), campingss.getTelefono(), campingss.getDireccion(), campingss.getEmail(), campingss.getWeb(), campingss.getTipoDeAlojamiento(), campingss.getCapacidad(), campingss.getCodigoPostal(), campingss.getLongitud(), campingss.getLatitud(), campingss.getMunicipio(), campingss.getTerritorio());
		}
		System.out.println("Cargados\n");
		
		Query query2 = session.createQuery("from Modelo.AlojamientoDB");
		
		List<AlojamientoDB> list = query2.list();
		
		if (jsonador.arraylistAlojamientostoJson(list))
			System.out.println("Json cargado");
		else {
			System.out.println("perdemos");
		}
		
		session.close();
	}

}
