package ConexionesBBDD;



import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;

public class ControladorUsuarios {
	
	SessionFactoryUtil sesion = SessionFactoryUtil.getInstance();
	
	public void addUsuarioDB(String dni, String nombre, String apellido, String email){
		
	      Session session = sesion.factory.openSession();
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
