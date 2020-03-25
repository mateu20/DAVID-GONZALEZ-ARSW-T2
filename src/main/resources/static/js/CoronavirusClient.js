CoronavirusClient= (function(){
    return {
 
        getStatsByName: function(name,callback){

            jQuery.ajax({
                url: "coronavirusstats/" + name ,
                success: function(result) {
                  callback(result,name);
                },
                 error: function(XMLHttpRequest, textStatus, errorThrown) { 
                     alert("Nombre no encontrado");
                     
                } ,
                async: true
            });
        },
    getAllStats: function(callback){

        jQuery.ajax({
            url: "coronavirusstats/",
            success: function(result) {
              callback(result);
            },
             error: function(XMLHttpRequest, textStatus, errorThrown) { 
                 alert("No encontrado");
                 
            } ,
            async: true
        });
    },
    
    getLocationByName: function(provincias,callback){

        jQuery.ajax({
            url: "coronavirusstats/location/" + name ,
            success: function(result) {
              callback(result,provincias);
            },
             error: function(XMLHttpRequest, textStatus, errorThrown) { 
                 alert("Nombre no encontrado");
                 
            } ,
            async: true
        });
    }
    
    };
})();