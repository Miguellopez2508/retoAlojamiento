package ConexionesBBDD;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import Modelo.AlojamientoDB;


public class ControladorAlojamiento {
	
	SessionFactoryUtil sesion = SessionFactoryUtil.getInstance();
	
	public void addAlojamientoBD(String SIGNATURA, String NOMBRE,	String DESCRIPCION,	String TELEFONO, String	DIRECCION, String EMAIL, String	WEB, String	TIPO, int CAPACIDAD, int CODIGO_POSTAL,	String LATITUD, String LONGITUD){
		
		Session session = sesion.factory.openSession();
		Transaction tx = null;
		        
		try {
			tx = session.beginTransaction();
			AlojamientoDB alojamientoDB = new AlojamientoDB(SIGNATURA, NOMBRE, DESCRIPCION, TELEFONO, DIRECCION, EMAIL, WEB, TIPO, CAPACIDAD, CODIGO_POSTAL, LATITUD, LONGITUD);
			session.save(alojamientoDB); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		} 
	}
	
	public void updateAlojamientoNombre(Integer AlojamientoID, String nombre){
		
		Session session = sesion.factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			AlojamientoDB alojamientoDB = (AlojamientoDB)session.get(AlojamientoDB.class, AlojamientoID); 
			alojamientoDB.setNombre(nombre);        
			session.update(alojamientoDB); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
}
