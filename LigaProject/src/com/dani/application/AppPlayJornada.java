package com.dani.application;

import com.dani.entidad.Jornadas;
import com.dani.methods.PlayMethods;

class AppPlayJornada {

	private AppPlayJornada() {
	    throw new IllegalStateException("Utility class");
	}
	
	public static void execute() {
		
		Jornadas jornada = PlayMethods.buscarSiguienteJornada();
	}
}
