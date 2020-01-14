package TratamientoDatos;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ConexionesBBDD.ControladorAlojamiento;
import ConexionesBBDD.ControladorMd5Alojamiento;
import Modelo.AlojamientoDB;
import Modelo.Md5Alojamiento;

public class TratarMD5 {

	public String stringToMD5(String cadena) {
		byte[] bytesOfMessage;
		
		try {
			bytesOfMessage = cadena.getBytes("UTF-8");
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);
			
			BigInteger no = new BigInteger(1, thedigest); 
			String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
		} catch (UnsupportedEncodingException e) {	
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;		
	}		
	
	
	public void compararHash(String datos, List<Md5Alojamiento> list1, Session session, ArrayList<AlojamientoDB> ArrayAlojamientosRurales, ArrayList<AlojamientoDB> ArrayCampings, ArrayList<AlojamientoDB> ArrayAlbergues ) {
		
		if (stringToMD5(datos).equals(list1.get(0).getHash())) {
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
			md5.updateAlojamientoBD(0, stringToMD5(datos));
			
			System.out.println("Cargados\n");
		}
	}
}
