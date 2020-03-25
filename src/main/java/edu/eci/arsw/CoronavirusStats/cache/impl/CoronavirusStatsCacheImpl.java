package edu.eci.arsw.CoronavirusStats.cache.impl;


import java.util.HashMap;

import org.springframework.stereotype.Service;

import edu.eci.arsw.CoronavirusStats.cache.CoronavirusStatsCache;

@Service("CVCacheImpl")
public class CoronavirusStatsCacheImpl implements CoronavirusStatsCache {

	HashMap<String,String> covidbyname = new  HashMap<String,String>();
    HashMap<String,Long> covidtime = new  HashMap<String,Long>();
    /**
     * Metodo que guarda el covid por pais en un objeto json
     */
    public void save(String name, String json) {
        covidbyname.put(name, json);
        covidtime.put(name,System.currentTimeMillis());
    }
    /**
     * Metodo que duvuelve un valor booleano si el covid19 por pais fue guardado exitosamente
     */
    @Override
    
    public boolean isSave(String name) {
        return covidbyname.containsKey(name);
    }
    /**
     * Metodo que determina si pasaron mas de los 5 minutos para almacenar en el cache
     */
    
    @Override    
    public String load(String name) {
        String covid19 = covidbyname.get(name);        
        long timeLoad =( System.currentTimeMillis()-covidtime.get(name))/1000;        
        if (timeLoad>300){
            covidbyname.remove(name);
            covidtime.remove(name);
        }
        
        return covid19;
         
    }
    
	
	

}