package com.dani.Applicacion;

import org.hibernate.Session;

import com.dani.entity.Equipos;
import com.dani.entity.Jornadas;
import com.dani.entity.Pruebas;
import com.dani.util.HibernateUtil;

public class MainApp {

	static Session session;
	
	public static void main(String[] args) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
//		prueba1();
		prueba2();
		
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	private static void prueba2() {
		Equipos equipo = session.get(Equipos.class, 1);
		Jornadas jornada = new Jornadas(1, 2, equipo);
		session.save(jornada);
		
		
	}

	public static void prueba1() {
		Pruebas prueba = new Pruebas("Antonio");
		session.save(prueba);
		Pruebas pruebas1 = session.get(Pruebas.class, 1);
	}
}
