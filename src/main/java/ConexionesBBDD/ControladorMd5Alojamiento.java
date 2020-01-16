package ConexionesBBDD;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Modelo.Md5Alojamiento;

public class ControladorMd5Alojamiento {
	
SessionFactoryUtil sesion = SessionFactoryUtil.getInstance();
	
	public void addAlojamientoBD(String hash){
		
		Session session = sesion.factory.openSession();
		Transaction tx = null;
		        
		try {
			tx = session.beginTransaction();
			Md5Alojamiento md5 = new Md5Alojamiento("algo");
			session.save(md5); 
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		} 
	}
	
	public void updateAlojamientoBD(int AlojamientohashID, String nuevoHash){
		
		Session session = sesion.factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Md5Alojamiento alojamiento = (Md5Alojamiento)session.get(Md5Alojamiento.class, AlojamientohashID); 
			alojamiento.setId(0);
			alojamiento.setHash(nuevoHash);  
			session.update(alojamiento); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
}
