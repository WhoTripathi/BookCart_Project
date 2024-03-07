package com.bookcart.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.classloading.internal.TcclLookupPrecedence;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import com.bookcart.database.ConnectDB;
import com.bookcart.entity.RegisteredUser;

public class LoginDAOImpl implements LoginDAO {

	public RegisteredUser checkCredentials(String email, String password) {
		SessionFactory sf = ConnectDB.buildConnection();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		String queString = "from RegisteredUser where userEmail=:x and password=:y";
		Query query = session.createQuery(queString);
		query.setParameter("x", email);
		query.setParameter("y", password);
		// Single element
		RegisteredUser rsRegisteredUser=(RegisteredUser)query.uniqueResult();
		return rsRegisteredUser;
	
	}

}
