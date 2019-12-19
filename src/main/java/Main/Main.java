package Main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import ConexionesBBDD.ControladorAlojamiento;
import ConexionesBBDD.ControladorUsuarios;
import ConexionesBBDD.SessionFactoryUtil;
import Modelo.AlojamientoDB;
import TratamientoDatos.DescargaXml;
import TratamientoDatos.LeerXml;
import TratamientoDatos.TratarJson;

public class Main {

	public static void main(String[] args) {
		
		LeerXml leerXml = new LeerXml();
		DescargaXml descargarXml = new DescargaXml();
		TratarJson jsonador = new TratarJson();
		
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
			miControlador2.addAlojamientoBD(campingss.getSignatura(), campingss.getNombre(), campingss.getDescripcion(), campingss.getTelefono(), campingss.getDireccion(), campingss.getEmail(), campingss.getWeb(), campingss.getTipoDeAlojamiento(), campingss.getCapacidad(), campingss.getCodigoPostal(), campingss.getLongitud(), campingss.getLatitud());	
		}	
		for (AlojamientoDB campingss : ArrayAlojamientosRurales) {
			miControlador2.addAlojamientoBD(campingss.getSignatura(), campingss.getNombre(), campingss.getDescripcion(), campingss.getTelefono(), campingss.getDireccion(), campingss.getEmail(), campingss.getWeb(), campingss.getTipoDeAlojamiento(), campingss.getCapacidad(), campingss.getCodigoPostal(), campingss.getLongitud(), campingss.getLatitud());
		}	
		for (AlojamientoDB campingss : ArrayAlbergues) {
			miControlador2.addAlojamientoBD(campingss.getSignatura(), campingss.getNombre(), campingss.getDescripcion(), campingss.getTelefono(), campingss.getDireccion(), campingss.getEmail(), campingss.getWeb(), campingss.getTipoDeAlojamiento(), campingss.getCapacidad(), campingss.getCodigoPostal(), campingss.getLongitud(), campingss.getLatitud());
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
