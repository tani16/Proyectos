package com.dani.methods;

import org.apache.commons.math3.random.RandomDataGenerator;

import com.dani.dao.EstadisticasDao;
import com.dani.dao.JornadasDao;
import com.dani.dao.PartidosDao;
import com.dani.daoimpl.EstadisticasDaoImpl;
import com.dani.daoimpl.JornadasDaoImpl;
import com.dani.daoimpl.PartidosDaoImpl;
import com.dani.entidad.Equipos;
import com.dani.entidad.Estadisticas;
import com.dani.entidad.Jornadas;
import com.dani.entidad.Partidos;

public class PlayMethods {
	
	private static JornadasDao jornadasDao = new JornadasDaoImpl();
	private static PartidosDao partidosDao = new PartidosDaoImpl();
	private static EstadisticasDao estadisticasDao = new EstadisticasDaoImpl();
	
	private PlayMethods() {
		throw new IllegalStateException("Utility class");
	}

	public static Jornadas searchNextJornada() {
				
		return jornadasDao.nextJornada();
	}

	public static Partidos searchNextPartido(Jornadas jornada) {
		
		return partidosDao.nextPartido(jornada);
	}

	public static Estadisticas getStatics(Equipos equipo) {
		
		return estadisticasDao.getStatics(equipo);
	}

	public static double analizeStaticsCasa(Estadisticas statics, double golesCFuera) {
		
		final double CTE = (double)552/380;
		
		double fuerzaAtaque = statics.getGfCasa() / CTE;
		double fuerzaDefensa = golesCFuera / CTE;
		
		double phiPrima = CTE * fuerzaAtaque * fuerzaDefensa;
		
		double phi = phiPrima - 0.3 + statics.getPosicionAnterior() + statics.getPresupuesto() 
					 + statics.getRacha() + statics.getValorMercado();
		
		return phi;
	}

	public static double analizeStaticsFuera(Estadisticas statics, double golesCCasa) {
		final double CTE = (double)431/380;
		
		double fuerzaAtaque = statics.getGfFuera() / CTE;
		double fuerzaDefensa = golesCCasa / CTE;
		
		double phiPrima = CTE * fuerzaAtaque * fuerzaDefensa;
		
		double phi = phiPrima - 0.3 + statics.getPosicionAnterior() + statics.getPresupuesto() 
					 + statics.getRacha() + statics.getValorMercado();
		
		return phi;
	}

	public static int CalculateGoals(double phiC) {
		
		RandomDataGenerator rd = new RandomDataGenerator();
		
		return (int) rd.nextPoisson(phiC);
	}

	public static void logConsoleResultado(Partidos partido) {
		
		System.out.println(partido.getEquipoC().getNombre() + " " 
				+ partido.getIdResultado().getGolesC() + " - " + partido.getIdResultado().getGolesF()
				+ " " + partido.getEquipoF().getNombre());
		
	}

}
