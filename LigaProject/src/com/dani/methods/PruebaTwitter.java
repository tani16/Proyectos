package com.dani.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class PruebaTwitter {

	public PruebaTwitter() throws TwitterException {	
			
		Twitter twitter = new TwitterFactory().getInstance();
//		RequestToken requestToken = twitter.getOAuthRequestToken();                
//        AccessToken accessToken = twitter.getOAuthAccessToken();
        

        Status status = twitter.updateStatus("Primera prueba de comunicaci�n \r\n desde app");
	}

}
