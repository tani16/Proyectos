package com.dani.application;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import com.dani.entidad.Equipos;
import com.dani.util.FicherosUtils;

class AppCargaDatos {
	private static List<String> jornadasTXT = new ArrayList<String>();
	
	private AppCargaDatos() {
	    throw new IllegalStateException("Utility class");
	}
	
	public static void execute() throws Exception {
		String linea;
		int contador = 0;
		

		BufferedReader lector = FicherosUtils.openFile();
		
		while((linea = lector.readLine()) != null) {
			
			for(int i = 0; i < 13; i++) {
				jornadasTXT.add(linea);
				linea = lector.readLine();
			}
			
			obtienePartidos();
			
			
			jornadasTXT.clear();
		}
		
		lector.close();
	}

	private static void obtienePartidos() {
		
		String[] infoPartido = new String[3];
		
		for(int i = 2; i < 12; i++) {
			infoPartido = jornadasTXT.get(i).split(";");
			
			Equipos equipoC = devuelveEquipo(infoPartido[1]);
		}
		
	}

	private static Equipos devuelveEquipo(String key) {
		
		Equipos equipo = null;
		int id = 0;
		
		switch (key) {
		case "Athletic":
			id = 1;
			break;
		case "Atletico":
			id = 2;
			break;	
		case "Leganes":
			id = 3;
			break;
		case "Osasuna":
			id = 4;
			break;
		case "Alaves":
			id = 5;
			break;
		case "Barcelona":
			id = 6;
			break;	
		case "Getafe":
			id = 7;
			break;
		case "Granada":
			id = 8;
			break;
		case "Levante":
			id = 9;
			break;
		case "Mallorca":
			id = 10;
			break;
		case "Celta":
			id = 11;
			break;
		case "Espanyol":
			id = 12;
			break;	
		case "Betis":
			id = 13;
			break;
		case "Real Madrid":
			id = 14;
			break;
		case "R. Sociedad":
			id = 15;
			break;
		case "Valladolid":
			id = 16;
			break;	
		case "Eibar":
			id = 17;
			break;
		case "Sevilla":
			id = 18;
			break;
		case "Valencia":
			id = 19;
			break;
		case "Villarreal":
			id = 20;
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
		
		equipo = EquiposDao.getEquipoById(id);
		
		return equipo;
	}
}

