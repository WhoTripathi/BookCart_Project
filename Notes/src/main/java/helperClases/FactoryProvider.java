package helperClases;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Notes;
import Entity.RegisteredUsers;

public class FactoryProvider {

	public static SessionFactory factory;

	public static SessionFactory getFactory() {
		if (factory == null) {

			Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Notes.class).addAnnotatedClass(RegisteredUsers.class);
			factory=con.buildSessionFactory();
		}
		return factory;
	}

	public static void closeFactory() {
		if (factory.isOpen()) {
			factory.close();
		}
	}

}
