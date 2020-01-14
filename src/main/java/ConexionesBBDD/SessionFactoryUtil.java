package ConexionesBBDD;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryUtil {

	public static SessionFactoryUtil factoryUtil;
	
	public SessionFactory factory;
	
	public static SessionFactoryUtil getInstance() {
		if (factoryUtil == null) { 
			factoryUtil = new SessionFactoryUtil();
		}
	        return factoryUtil;
	}
	
	public SessionFactoryUtil() {
		try { 
			factory = new Configuration().configure().buildSessionFactory(); 
		}
		catch (HibernateException ex) { 
			System.err.println("Failed to create sessionFactory object." + ex); 
			throw new ExceptionInInitializerError(ex); 
		} 
	}
	
}
