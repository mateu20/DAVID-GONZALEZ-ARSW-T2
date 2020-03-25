package edu.eci.arsw.CoronavirusStats.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.CoronavirusStats.Services.CoronavirusStatsServices;

/**
 * 
 * @author Mateo Gonzalez
 *
 */
@RestController
@RequestMapping(value = "/coronavirusstats")
public class CoronavirusStatsController {
	@Autowired
    @Qualifier("CoronavirusServicesImpl")
    CoronavirusStatsServices coronaservices;
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getStats() {
        try {
           
            return new ResponseEntity<>(coronaservices.getAllStats().toString(),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
	
	
	 @RequestMapping(path = "/{name}", method = RequestMethod.GET)
	    public ResponseEntity<?> getStatsByName(@PathVariable(name = "name") String nombre) {
	        try {
	           
	            return new ResponseEntity<>(coronaservices.getStatsByName(nombre).toString(),HttpStatus.ACCEPTED);

	        } catch (Exception ex) {
	            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
	        }
	    }
	
}
