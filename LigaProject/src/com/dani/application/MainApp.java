package com.dani.application;

import org.hibernate.Session;

import com.dani.util.HibernateUtils;

public class MainApp {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtils.getTransaction();
		//AppCargaDatos.execute();
		AppPlayJornada.execute();

	}
}
