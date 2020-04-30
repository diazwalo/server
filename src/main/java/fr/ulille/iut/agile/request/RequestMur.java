package fr.ulille.iut.agile.request;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.ulille.iut.agile.beans.ListVilles;
import fr.ulille.iut.agile.beans.Mur;

@Path("mur")
public class RequestMur implements Request {

	@GET
	@Path("add/{uuid}/{superficie}/{ville}/{name}")
	public JsonObject addMur(@PathParam("uuid") String pUUID, @PathParam("superficie") String pSuperficie, @PathParam("ville") String pVille,
			@PathParam("name") String pName) {
		
		update(pUUID);
		
		JsonObjectBuilder json = Json.createObjectBuilder();
		
		// Recuperer l'utilisateur via son uuid
		
		try {
			float superficie = Float.parseFloat(pSuperficie);
			if(!ListVilles.instance.exist(pVille)) {
				json.add("mur", "ville incorrecte");
			}
			
			new Mur(superficie, pVille, pName);
			json.add("mur", "ajoute avec succes");
		} catch(NumberFormatException e) {
			json.add("mur", "parametres incorrectes");
		}
		
		return json.build();
	}
	
}
