package com.dani.application;

import com.dani.entidad.Estadisticas;
import com.dani.entidad.Jornadas;
import com.dani.entidad.Partidos;
import com.dani.entidad.Resultados;
import com.dani.methods.PlayMethods;
import com.dani.methods.TwitterMethods;

import twitter4j.TwitterException;

class AppPlayJornada {

	private AppPlayJornada() {
	    throw new IllegalStateException("Utility class");
	}
	
	public static void execute() throws TwitterException {
		
		Jornadas jornada = PlayMethods.searchNextJornada();
		
		Partidos partido = PlayMethods.searchNextPartido(jornada);
			
		Estadisticas estadisticasC = PlayMethods.getStatics(partido.getEquipoC());				
		Estadisticas estadisticasF = PlayMethods.getStatics(partido.getEquipoF());
		
		double phiC = PlayMethods.analizeStaticsCasa(estadisticasC, estadisticasF.getGcFuera());
		double phiF = PlayMethods.analizeStaticsFuera(estadisticasF, estadisticasC.getGcCasa());
		
		Resultados resultado = new Resultados();
		resultado.setGolesC(PlayMethods.CalculateGoals(phiC));
		resultado.setGolesF(PlayMethods.CalculateGoals(phiF));
		
		// Guardar resultado
		
		partido.setIdResultado(resultado);
		
		PlayMethods.logConsoleResultado(partido);
		String post = TwitterMethods.getPost(partido);
		TwitterMethods.postResult(post); 
	}
}
