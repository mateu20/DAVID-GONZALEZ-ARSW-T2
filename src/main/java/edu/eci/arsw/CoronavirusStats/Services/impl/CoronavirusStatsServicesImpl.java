package edu.eci.arsw.CoronavirusStats.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.CoronavirusStats.Services.CoronavirusStatsServices;
import edu.eci.arsw.CoronavirusStats.Services.HttpConnectionService;

@Service("CoronavirusServicesImpl")
public class CoronavirusStatsServicesImpl implements CoronavirusStatsServices{

	@Autowired
    @Qualifier("HttpServicesImpl")
    HttpConnectionService httpServices;
	
	@Override
	public JsonNode getStatsByName(String nombre) throws UnirestException {
		return httpServices.getStatsbyName(nombre);
	}

	@Override
	public JsonNode getAllStats() throws UnirestException {
		
		return httpServices.getAllStats();
	}

}
