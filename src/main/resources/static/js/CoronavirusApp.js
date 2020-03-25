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
	 


		var mapeadorPorPais = function(stats){
				
			$("#PorPais tbody tr").remove();
			var paisactual="";
			
			stats=JSON.parse(stats);
			var paisactual=stats.data.covid19Stats[0].country;
			stats = stats.data.covid19Stats;
			var paises = new Map();
			var nombres = [];
			var muertes=0;
			var infectados=0;
			var recuperados=0;
			 stats.map(function(country){
				 
				 if (paises.get(country.country)==undefined){
					 nombres.push(country.country);
					 var variables = [country.deaths,country.confirmed,country.recovered];
					 paises.set(country.country,variables);
				 }
				 else{
					 var variables = paises.get(country.country);
					 variables[0]=variables[0]+country.deaths;
					 variables[1]=variables[1]+country.confirmed;
					 variables[2]=variables[2]+country.recovered;
					 paises.set(country.country,variables);
				 }
				
					 
	         })
	         
	        nombres.map(function(country){
				 
	        		var variables = paises.get(country);
					 var contenedor = "<tr><td onClick=\"CoronavirusModule.getStatsbyName('"+country+"')\">"+country+"</td> <td>"+variables[0]+"</td> <td>"+variables[1]+"</td> <td>"+variables[2]+"</td></tr>";     
					 $("#PorPais tbody").append(contenedor);
					 
	         })
	         
			
		}
		
		var locationPais = function(provincias,name){
			alert(name);
        	CoronavirusClient.getLocationByName(provincias,mapeadorPorProvincia);
		}
		
		var mapeadorPorProvincia = function(paislocation,provincias){
			alert(paislocation);
			alert(provincias);
		}
		
		
        var getStatsbyName = function(name){
			alert(name);
        	CoronavirusClient.getStatsByName(name,locationPais);
		}
		
		var getAllStats= function(){
			
			CoronavirusClient.getAllStats(mapeadorPorPais);
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
		mapeadorPorProvincia: mapeadorPorProvincia,
		locationPais:locationPais

	};
	

})();