 var CoronavirusModule =( function (){
	
	
	
	return {
		mapeador: function(stats){
			
			
		},
		mapeadorPorPais: function(stats){
			
			 stats=JSON.parse(stats);
			 
			
	   
	        	   stats.map(function(country){
	                   var contenedor = "<tr><td>"+country.data.country+"</td> <td>"+country.data.deaths+"</td> <td>"+country.data.confirmed+"</td> <td>"+country.data.recovered+"</td></tr>";
	                   
	                    
	                  
	                 
	   
	                    
	   
	   
	                    $("#PorPais tbody").append(contenedor);

	               })
			
		},
        getStatsbyName: function(){
			
        	CoronavirusClient.getStatsByName(name,mapeador);
		},
		
		getAllStats: function(){
			
        	CoronavirusClient.getStatsByName(mapeadorPorPais);
		},
		
        initMap: function(){
        	map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: -34.397, lng: -4.0},
                zoom: 8
              });

              fetch('https://raw.githubusercontent.com/jayshields/google-maps-api-template/master/markers.json')
                .then(function(response){return response.json()})
                .then(plotMarkers);
			
		}
	};
})();