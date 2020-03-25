package edu.eci.arsw.CoronavirusStats.Services;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface CoronavirusStatsServices {

	JsonNode getStatsByName(String nombre) throws UnirestException;

	JsonNode getAllStats()  throws UnirestException;

}
