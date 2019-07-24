package com.dani.methods;

import com.dani.entidad.Partidos;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterMethods {
	
	private final static String ENTER = "\r\n";
	
	private TwitterMethods() {
		throw new IllegalStateException("Utility class");
	}
	
	
	public static void postResult(String post) throws TwitterException {
		
		Twitter twitter = new TwitterFactory().getInstance();
		
		twitter.updateStatus("Pruebas - " + post);
		
	}


	public static String getPost(Partidos partido) {
		
		return "Jornada " + partido.getJornada().getIdJornada() + ENTER +
			   partido.getEquipoC().getTwitter() + " " + partido.getResultado().getGolesC() + " - " +
			   partido.getResultado().getGolesF() + " " + partido.getEquipoF().getTwitter();				
		
	}
}
