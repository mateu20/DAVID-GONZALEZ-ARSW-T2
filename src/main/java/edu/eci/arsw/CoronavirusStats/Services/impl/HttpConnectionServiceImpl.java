package edu.eci.arsw.CoronavirusStats.Services.impl;

import org.springframework.stereotype.Service;
import org.apache.http.HttpStatus;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.CoronavirusStats.Services.HttpConnectionService;

@Service("HttpServicesImpl")
public class HttpConnectionServiceImpl implements HttpConnectionService{

	@Override
	public JsonNode getStatsbyName(String nombre) throws UnirestException {
		HttpResponse<JsonNode> response = Unirest
				.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+nombre)
				.header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
				.header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
				.asJson();
		
		return response.getBody();
		
	}

	@Override
	public JsonNode getAllStats() throws UnirestException {
		HttpResponse<JsonNode> response = Unirest
				.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
				.header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
				.header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
				.asJson();
		
		return response.getBody();
	}

}
