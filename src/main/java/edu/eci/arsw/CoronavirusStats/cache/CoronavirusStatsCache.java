package edu.eci.arsw.CoronavirusStats.cache;

import com.mashape.unirest.http.JsonNode;

public interface CoronavirusStatsCache {
	
	/**
	 * 
	 * @param name nombre a guardar
	 * @param json objeto en el que se guardara
	 */
    public void save (String name, String json);
    public boolean isSave(String name);
    public JsonNode load(String name);

}
