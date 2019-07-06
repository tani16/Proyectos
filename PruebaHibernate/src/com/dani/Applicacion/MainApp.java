package com.dani.Applicacion;

import org.hibernate.Session;

import com.dani.entity.Pruebas;
import com.dani.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		Pruebas prueba = new Pruebas("Antonio");
		session.save(prueba);
		

		
		Pruebas pruebas1 = session.get(Pruebas.class, 1);
		session.getTransaction().commit();
		session.close();
	}
}
