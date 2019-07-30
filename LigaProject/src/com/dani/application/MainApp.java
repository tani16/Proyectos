package com.dani.application;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

import com.dani.dao.ClasificacionDao;
import com.dani.daoimpl.ClasificacionDaoImpl;
import com.dani.entidad.Clasificacion;
import com.dani.methods.BufferMethods;
import com.dani.methods.ImageMethods;
import com.dani.util.HibernateUtils;

import twitter4j.TwitterException;

public class MainApp {
	
	public static void main(String[] args) throws TwitterException, IOException {
		
		Session session = HibernateUtils.getTransaction();
		//AppCargaDatos.execute();
		AppPlayJornada.execute();
	}
}
