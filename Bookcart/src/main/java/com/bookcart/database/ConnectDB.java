package com.bookcart.database;



import java.security.PublicKey;
import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectDB {
	
	public static SessionFactory sFactory;
	public static SessionFactory buildConnection()
	{
		
		try {
			
			Configuration cfg=new Configuration();
			cfg.configure();
			sFactory=cfg.buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sFactory;
	}
	public static void closeConnection()
	{	
		if(sFactory.isOpen())
		{
			sFactory.close();
		}
	}

}
