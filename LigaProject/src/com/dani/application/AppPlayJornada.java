package com.dani.application;

import java.io.IOException;

import com.dani.entidad.Estadisticas;
import com.dani.entidad.Jornadas;
import com.dani.entidad.Partidos;
import com.dani.entidad.Resultados;
import com.dani.methods.BufferMethods;
import com.dani.methods.PlayMethods;
import com.dani.methods.TwitterMethods;

import twitter4j.TwitterException;

class AppPlayJornada {

	private AppPlayJornada() {
	    throw new IllegalStateException("Utility class");
	}
	
	public static void execute() throws TwitterException {
		
		Jornadas jornada = PlayMethods.searchNextJornada();
		
		for(int i = 0; i < 10; i++) {	
			playMatch(jornada);
		}
		
		
	}

	private static void playMatch(Jornadas jornada) {
		Partidos partido = PlayMethods.searchNextPartido(jornada);
			
		Estadisticas estadisticasC = PlayMethods.getStatics(partido.getEquipoC());				
		Estadisticas estadisticasF = PlayMethods.getStatics(partido.getEquipoF());
		
		double phiC = PlayMethods.analizeStaticsCasa(estadisticasC, estadisticasF.getGcFuera());
		double phiF = PlayMethods.analizeStaticsFuera(estadisticasF, estadisticasC.getGcCasa());
		
		Resultados resultado = new Resultados();
		resultado.setGolesC(PlayMethods.calculateGoals(phiC));
		resultado.setGolesF(PlayMethods.calculateGoals(phiF));
		
		partido.setResultado(resultado);
		PlayMethods.updateData(partido, resultado);
		
		PlayMethods.logConsoleResultado(partido);
		String post = TwitterMethods.getPost(partido);

		try {
			BufferMethods.postOnBuffer(post);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
