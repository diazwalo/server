package fr.ulille.iut.agile.request;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.ulille.iut.agile.beans.Cuve;

@Path("cuve")
public class RequestCuve implements Request {

	@GET
	@Path("add/{uuid}/{capacite}/{quantite}")
	public JsonObject addMur(@PathParam("uuid") String pUUID, @PathParam("capacite") String pCapacite, @PathParam("quantite") String pQte) {
		
		update(pUUID);
		
		JsonObjectBuilder json = Json.createObjectBuilder();
		
		// Recuperer l'utilisateur via son uuid
		
		try {
			float capacite = Float.parseFloat(pCapacite);
			float qte = Float.parseFloat(pQte);
			
			new Cuve(capacite, qte);
			json.add("cuve", "ajoutee avec succes");
		} catch(NumberFormatException e) {
			json.add("cuve", "parametres incorrectes");
		}
		
		return json.build();
	}
	
}
