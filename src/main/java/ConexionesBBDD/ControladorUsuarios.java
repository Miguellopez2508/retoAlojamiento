package ConexionesBBDD;


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

		ME.addUsuarioDB("87654321P", "GANAMOS" , "aaojk", "aa@gmail.com");
		

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
