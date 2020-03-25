package edu.eci.arsw.CoronavirusStats.Services;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface HttpConnectionService {

	JsonNode getStatsbyName(String nombre) throws UnirestException ;
	
	JsonNode getAllStats() throws UnirestException ;

	JsonNode getLocation(String nombre) throws UnirestException ;
}
