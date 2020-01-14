package Main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import ConexionesBBDD.ControladorAlojamiento;
import ConexionesBBDD.ControladorMd5Alojamiento;
import ConexionesBBDD.SessionFactoryUtil;
import Modelo.AlojamientoDB;
import Modelo.Md5Alojamiento;
import TratamientoDatos.DescargaXml;
import TratamientoDatos.LeerXml;
import TratamientoDatos.TratarJson;
import TratamientoDatos.TratarMD5;

public class Main {

	public static void main(String[] args) {
		
		//Declaracion de variables
		List<AlojamientoDB> list = null;
		List<Md5Alojamiento> list1 = null;
		String datos = "";
		Query query2 = null;
		Query query3 = null;
		Query query4 = null;
		
		ControladorMd5Alojamiento md5 = new ControladorMd5Alojamiento();
		LeerXml leerXml = new LeerXml();
		DescargaXml descargarXml = new DescargaXml();
		TratarJson jsonador = new TratarJson();
		TratarMD5 md5or = new TratarMD5();	
		
		SessionFactoryUtil sesion = null;
		Session session = null;
		
		String campings ="";
		String alojamientosRurales="";
		String albergues="";
		ArrayList<AlojamientoDB> ArrayCampings = null;
		ArrayList<AlojamientoDB> ArrayAlojamientosRurales = null;
		ArrayList<AlojamientoDB> ArrayAlbergues = null;
		
		//Hace la sesion de hibernate
		sesion = SessionFactoryUtil.getInstance();					
		session = sesion.factory.openSession();
		
		//Descarga los xml de los alojamientos de internet
		descargarXml.cogerRuta();
		
		//Rellena los arrays con los datos del xml 
		campings = System.getProperty("user.dir") + "\\campings.xml";
		alojamientosRurales = System.getProperty("user.dir") + "\\alojamientosRurales.xml";
		albergues = System.getProperty("user.dir") + "\\albergues.xml";
		
		ArrayCampings =  leerXml.leerXmlDeAlojamientos(campings);
		ArrayAlojamientosRurales =  leerXml.leerXmlDeAlojamientos(alojamientosRurales);
		ArrayAlbergues =  leerXml.leerXmlDeAlojamientos(albergues);
		
		//Comprueba si hay hash		
		try {			
			query3 = session.createQuery("from Modelo.Md5Alojamiento");	
			list1 = query3.list();
		}
		catch(Throwable ex){
			JOptionPane.showMessageDialog(null, "Error de conexion", "ERROR", JOptionPane.WARNING_MESSAGE);
		}
		
		//Si no hay ningun hash, inserta uno 
		if (list1.size() == 0) {
			
			md5.addAlojamientoBD("algo");	
			query4 = session.createQuery("from Modelo.Md5Alojamiento");			
			list1 = query4.list();
		}
		
		//Pasa todos los xml a un String
		datos = leerXml.pasarXmlAString("campings.xml");
		datos += leerXml.pasarXmlAString("alojamientosRurales.xml");
		datos += leerXml.pasarXmlAString("albergues.xml");
		
		//Compara los hashes
		md5or.compararHash(datos, list1, session, ArrayAlojamientosRurales, ArrayCampings, ArrayAlbergues);
		
		//obtiene los alojamientos
		query2 = session.createQuery("from Modelo.AlojamientoDB");		
		list = query2.list();
		
		if (jsonador.arraylistAlojamientostoJson(list))
			System.out.println("Json cargado");
		else {
			System.out.println("Json no cargado");
		}
		
		//Cierra sesion de hibernate
		session.close(); 
	}
}
