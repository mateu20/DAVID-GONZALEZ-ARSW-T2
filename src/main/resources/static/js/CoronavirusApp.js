var CoronavirusModule = (function () {

	document.addEventListener('DOMContentLoaded', function () {
		if (document.querySelectorAll('#map').length > 0) {
			if (document.querySelector('html').lang)
				lang = document.querySelector('html').lang;
			else
				lang = 'en';

			var js_file = document.createElement('script');
			js_file.type = 'text/javascript';
			js_file.src = 'https://maps.googleapis.com/maps/api/js?callback=initMap&signed_in=true&language=' + lang;
			document.getElementsByTagName('head')[0].appendChild(js_file);
		}
	});

	
	 var map;

	var mapeador = function () { }

		var mapeadorPorPais = function(stats){
			
			 stats=JSON.parse(stats);		
	   
	        	   stats.map(function(country){
	                   var contenedor = "<tr><td>"+country.data.country+"</td> <td>"+country.data.deaths+"</td> <td>"+country.data.confirmed+"</td> <td>"+country.data.recovered+"</td></tr>";     
	                       
	                    $("#PorPais tbody").append(contenedor);

	               })
			
		}
        var getStatsbyName = function(){
			
        	CoronavirusClient.getStatsByName(name,mapeador);
		}
		
		var getAllStats= function(){
			
			CoronavirusClient.getStatsByName(mapeadorPorPais);
		}
		
		function initMap() {
        	map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: -34.397, lng: -4.0},
                zoom: 8
              });

              fetch('https://raw.githubusercontent.com/jayshields/google-maps-api-template/master/markers.json')
				  .then(function (response) { return response.json() })
				  .then(this.getAllStats);
			
		}

	return {
		initMap: initMap,
		getAllStats: getAllStats,
		getStatsbyName: getStatsbyName,
		mapeadorPorPais: mapeadorPorPais,
		mapeador: mapeador

	};
	

})();