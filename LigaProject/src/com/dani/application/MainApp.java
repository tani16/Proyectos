package com.dani.application;

import java.io.IOException;

import org.hibernate.Session;

import com.dani.util.HibernateUtils;

import twitter4j.TwitterException;

public class MainApp {
	
	public static void main(String[] args) throws TwitterException, IOException {
		
		Session session = HibernateUtils.getTransaction();
		//AppCargaDatos.execute();
		AppPlayJornada.execute();
	}
}
