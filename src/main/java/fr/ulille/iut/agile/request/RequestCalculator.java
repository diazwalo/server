package fr.ulille.iut.agile.request;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.ulille.iut.agile.beans.ListVilles;

@Path("calcul")
public class RequestCalculator {

	@GET
	@Path("stockage/{consoJour}/{ville}")
	public JsonObject calculDimensionStockage(@PathParam("consoJour") String pConsoJour, @PathParam("ville") String pVille) {
		
		JsonObjectBuilder json = Json.createObjectBuilder();
		String stockage = "stockage";
		try {
			float consoJour = Float.parseFloat(pConsoJour);
			// Recuperer via la ville int nbJoursSansPluie = 
			
			float coef = ListVilles.instance.getCoefOf(pVille);
			if(coef == -1) {
				json.add(stockage, "ville incorrecte");
				return json.build();
			}
			
			float res = consoJour * /* A CHANGER */ 15 /* A CHANGER */ * coef / 1000;
			json.add("stockage", res);
		} catch(NumberFormatException e) {
			json.add(stockage, "parametres incorrectes");
		}
		
		return json.build();
	}
	
	@GET
	@Path("conso/{dimensionMur}/{consoJour}/{ville}")
	public JsonObject calculSurfaceHydratable(@PathParam("dimensionMur") String pDimensionMur, @PathParam("consoJour") String pConsoJour,
			@PathParam("ville") String pVille) {
		
		JsonObjectBuilder json = Json.createObjectBuilder();
		String conso = "conso";
		try {
			float dimensionMur = Float.parseFloat(pDimensionMur);
			float consoJour = Float.parseFloat(pConsoJour);
			
			float coef = ListVilles.instance.getCoefOf(pVille);
			if(coef == -1) {
				json.add(conso, "ville incorrecte");
				return json.build();
			}
			
			float res = dimensionMur * consoJour * coef;
			json.add(conso, res);
		} catch(NumberFormatException e) {
			json.add(conso, "parametres incorrectes");
		}
		
		return json.build();
	}
	
}
