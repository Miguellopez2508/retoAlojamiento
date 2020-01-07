package Main;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import ConexionesBBDD.ControladorAlojamiento;
import ConexionesBBDD.ControladorUsuarios;
import ConexionesBBDD.SessionFactoryUtil;
import Modelo.AlojamientoDB;
import TratamientoDatos.DescargaXml;
import TratamientoDatos.LeerXml;

public class Main {

	public static void main(String[] args) {
		
		LeerXml leerXml = new LeerXml();
		DescargaXml descargarXml = new DescargaXml();
		
		SessionFactoryUtil sesion = SessionFactoryUtil.getInstance();
		Session session = sesion.factory.openSession();
		
		descargarXml.cogerRuta();
		
		String campings = System.getProperty("user.dir") + "\\campings.xml";
		String alojamientosRurales = System.getProperty("user.dir") + "\\alojamientosRurales.xml";
		String albergues = System.getProperty("user.dir") + "\\albergues.xml";
		
		ArrayList<AlojamientoDB> ArrayCampings =  leerXml.leerXmlDeAlojamientos(campings);
		ArrayList<AlojamientoDB> ArrayAlojamientosRurales =  leerXml.leerXmlDeAlojamientos(alojamientosRurales);
		ArrayList<AlojamientoDB> ArrayAlbergues =  leerXml.leerXmlDeAlojamientos(albergues);
		
		String hql = "delete from Modelo.AlojamientoDB";
		Query query = session.createQuery(hql);	
		query.executeUpdate();
		
//		ControladorUsuarios miControlador1 = new ControladorUsuarios();
//		miControlador1.addUsuarioDB("fsdfs", "asda", "dasf", "ads");
		
		ControladorAlojamiento miControlador2 = new ControladorAlojamiento();
		
		for (AlojamientoDB campingss : ArrayCampings) {
			miControlador2.addAlojamientoBD(campingss.getSignatura(), campingss.getNombre(), campingss.getDescripcion(), campingss.getTelefono(), campingss.getDireccion(), campingss.getEmail(), campingss.getWeb(), campingss.getTipoDeAlojamiento(), campingss.getCapacidad(), campingss.getCodigoPostal(), campingss.getLongitud(), campingss.getLatitud(), campingss.getMunicipio(), campingss.getTerritorio());	
		}	
		for (AlojamientoDB campingss : ArrayAlojamientosRurales) {
			miControlador2.addAlojamientoBD(campingss.getSignatura(), campingss.getNombre(), campingss.getDescripcion(), campingss.getTelefono(), campingss.getDireccion(), campingss.getEmail(), campingss.getWeb(), campingss.getTipoDeAlojamiento(), campingss.getCapacidad(), campingss.getCodigoPostal(), campingss.getLongitud(), campingss.getLatitud(), campingss.getMunicipio(), campingss.getTerritorio());
		}	
		for (AlojamientoDB campingss : ArrayAlbergues) {
			miControlador2.addAlojamientoBD(campingss.getSignatura(), campingss.getNombre(), campingss.getDescripcion(), campingss.getTelefono(), campingss.getDireccion(), campingss.getEmail(), campingss.getWeb(), campingss.getTipoDeAlojamiento(), campingss.getCapacidad(), campingss.getCodigoPostal(), campingss.getLongitud(), campingss.getLatitud(), campingss.getMunicipio(), campingss.getTerritorio());
		}
	}

}
