package com.dani.methods;

import com.dani.dao.JornadasDao;
import com.dani.daoimpl.JornadasDaoImpl;
import com.dani.entidad.Jornadas;

public class PlayMethods {
	
	private static JornadasDao jornadaDao = new JornadasDaoImpl();
	
	private PlayMethods() {
		throw new IllegalStateException("Utility class");
	}

	public static Jornadas buscarSiguienteJornada() {
				
		return jornadaDao.nextJornada();
	}

}