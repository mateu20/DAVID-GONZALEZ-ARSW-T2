package edu.eci.arsw.CoronavirusStats.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.CoronavirusStats.Services.CoronavirusStatsServices;
import edu.eci.arsw.CoronavirusStats.Services.HttpConnectionService;
import edu.eci.arsw.CoronavirusStats.cache.CoronavirusStatsCache;

@Service("CoronavirusServicesImpl")
public class CoronavirusStatsServicesImpl implements CoronavirusStatsServices{

	@Autowired
    @Qualifier("HttpServicesImpl")
    HttpConnectionService httpServices;
	
	@Autowired
	@Qualifier("CVCacheImpl")
	 CoronavirusStatsCache CSC;
	
	@Override
	public JsonNode getStatsByName(String nombre) throws UnirestException {
		if (!CSC.isSave(nombre)) {
		 httpServices.getStatsbyName(nombre);}
		return CSC.load(nombre);
	}

	@Override
	public JsonNode getAllStats() throws UnirestException {
		
		return httpServices.getAllStats();
	}

	@Override
	public JsonNode getLocationByName(String nombre) throws UnirestException {
		
		return httpServices.getLocation(nombre);
	}

}
