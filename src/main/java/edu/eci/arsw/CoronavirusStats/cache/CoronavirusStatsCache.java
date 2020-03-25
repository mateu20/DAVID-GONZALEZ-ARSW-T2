package edu.eci.arsw.CoronavirusStats.cache;

public interface CoronavirusStatsCache {
	
	/**
	 * 
	 * @param name nombre a guardar
	 * @param json objeto en el que se guardara
	 */
    public void save (String name, String json);
    public boolean isSave(String name);
    public String load(String name);

}
