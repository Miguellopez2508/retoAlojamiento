package Main;

import java.util.ArrayList;
import java.util.List;
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
		
		LeerXml leerXml = new LeerXml();
		DescargaXml descargarXml = new DescargaXml();
		TratarJson jsonador = new TratarJson();
		TratarMD5 md5or = new TratarMD5();
						
		SessionFactoryUtil sesion = SessionFactoryUtil.getInstance();
		Session session = sesion.factory.openSession();
		
		descargarXml.cogerRuta();
		
		String campings = System.getProperty("user.dir") + "\\campings.xml";
		String alojamientosRurales = System.getProperty("user.dir") + "\\alojamientosRurales.xml";
		String albergues = System.getProperty("user.dir") + "\\albergues.xml";
		
		ArrayList<AlojamientoDB> ArrayCampings =  leerXml.leerXmlDeAlojamientos(campings);
		ArrayList<AlojamientoDB> ArrayAlojamientosRurales =  leerXml.leerXmlDeAlojamientos(alojamientosRurales);
		ArrayList<AlojamientoDB> ArrayAlbergues =  leerXml.leerXmlDeAlojamientos(albergues);
		
		//comprueba si hay hash
		Query query3 = session.createQuery("from Modelo.Md5Alojamiento");	
		List<Md5Alojamiento> list1 = query3.list();
	
		//si no hay, inserta uno cualquiera
		if (list1.size() == 0) {
			ControladorMd5Alojamiento md5 = new ControladorMd5Alojamiento();
			md5.addAlojamientoBD("algo");
			
			Query query4 = session.createQuery("from Modelo.Md5Alojamiento");			
			list1 = query4.list();
		}
		
		String datos = leerXml.pasarXmlAString("campings.xml");
		datos += leerXml.pasarXmlAString("alojamientosRurales.xml");
		datos += leerXml.pasarXmlAString("albergues.xml");
		
		//compara los hashes
		if (md5or.stringToMD5(datos).equals(list1.get(0).getHash())) {
			System.out.println("Las tablas están actualizadas");		
		} else {
			System.out.println("Reseteando tablas...");
			String hql = "delete from Modelo.AlojamientoDB";
			Query query = session.createQuery(hql);	
			query.executeUpdate();
			System.out.println("Reseteadas\n");
			
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
			
			//inserta el nuevo hash
			ControladorMd5Alojamiento md5 = new ControladorMd5Alojamiento();			
			md5.updateAlojamientoBD(0, md5or.stringToMD5(leerXml.pasarXmlAString("albergues.xml")));
			
			System.out.println("Cargados\n");
		}
		
		//obtiene los alojamientos
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
