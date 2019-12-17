package ConexionesBBDD;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ControladorUsuarios {
	
	private static SessionFactory factory; 
	public static void main(String[] args) { 
		
		try { 
			factory = new Configuration().configure().buildSessionFactory(); 
		} catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex); 
			throw new ExceptionInInitializerError(ex); 
		} 
		
		ControladorUsuarios ME = new ControladorUsuarios(); 
		/* Add few UsuarioDB records in database */ 
		 ME.addUsuarioDB("87654321A", "piter" , "aa", "aa@gmail.com");
		
//		/* List down all the UsuarioDBs */ 
//		ME.listUsuarioDBs(); 
//		/* Update UsuarioDB's records */ 
//		ME.updateUsuarioDB(empID1, 5000); 
//		/* Delete an UsuarioDB from the database */ 
//		ME.deleteUsuarioDB(empID2); 
//		/* List down new list of the UsuarioDBs */ 
//		ME.listUsuarioDBs(); 
		}

	
	public void addUsuarioDB(String dni, String nombre, String apellido, String email){
		
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      
	      try {
	         tx = session.beginTransaction();
	         UsuarioDB UsuarioDB = new UsuarioDB(dni, nombre, apellido, email);
	         session.save(UsuarioDB); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      
	   }
}
