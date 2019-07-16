package com.dani.application;

import org.hibernate.Session;

import com.dani.methods.PruebaTwitter;
import com.dani.util.HibernateUtils;

import twitter4j.TwitterException;

public class MainApp {
	
	public static void main(String[] args) throws TwitterException {
		
		Session session = HibernateUtils.getTransaction();
		//AppCargaDatos.execute();
		AppPlayJornada.execute();
		
	}
}
