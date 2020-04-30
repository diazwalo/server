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
	@Path("stockage/{consoJour}/{nbJoursSansPluie}/{ville}")
	public JsonObject calculDimensionStockage(@PathParam("consoJour") String pConsoJour, @PathParam("nbJoursSansPluie") String pNbJoursSansPluie,
			@PathParam("ville") String pVille) {
		
		JsonObjectBuilder json = Json.createObjectBuilder();
		try {
			float consoJour = Float.parseFloat(pConsoJour);
			int nbJoursSansPluie = Integer.parseInt(pNbJoursSansPluie);
			
			float coef = ListVilles.instance.getCoefOf(pVille);
			if(coef == -1) {
				json.add("value", "ville incorrecte");
				return json.build();
			}
			
			float res = consoJour * nbJoursSansPluie * coef / 1000;
			json.add("value", res);
		} catch(NumberFormatException e) {
			json.add("value", "parametres incorrectes");
		}
		
		return json.build();
	}
	
	@GET
	@Path("surface/{dimensionMur}/{consoJour}/{ville}")
	public JsonObject calculSurfaceHydratable(@PathParam("dimensionMur") String pDimensionMur, @PathParam("consoJour") String pConsoJour,
			@PathParam("ville") String pVille) {
		
		JsonObjectBuilder json = Json.createObjectBuilder();
		try {
			float dimensionMur = Float.parseFloat(pDimensionMur);
			float consoJour = Float.parseFloat(pConsoJour);
			
			float coef = ListVilles.instance.getCoefOf(pVille);
			if(coef == -1) {
				json.add("value", "ville incorrecte");
				return json.build();
			}
			
			float res = dimensionMur * consoJour * coef;
			json.add("value", res);
		} catch(NumberFormatException e) {
			json.add("value", "parametres incorrectes");
		}
		
		return json.build();
	}
	
}
