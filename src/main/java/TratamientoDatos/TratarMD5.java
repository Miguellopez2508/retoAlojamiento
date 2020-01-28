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
	
	
	public boolean compararHash(String datos, List<Md5Alojamiento> list1) {		
		
		if (stringToMD5(datos).equals(list1.get(0).getHash())) {
			return true;
		} else {
			return false;
		}
	}
}
