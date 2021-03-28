package factories;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Student;

public class SessionFactoryBuilder {
	public static SessionFactory SessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if(SessionFactory == null)
			SessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		return SessionFactory;
	}
	
	public static void closeSessionFactory() {
		if(SessionFactory != null)
			SessionFactory.close();	
	}
}