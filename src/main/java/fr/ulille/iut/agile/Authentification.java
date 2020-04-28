package fr.ulille.iut.agile;

import java.util.UUID;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("authent")
public class Authentification 
{
	@GET
	@Path("{name}/{mdp}")
	public JsonObject authentification(@PathParam("name") String pName, @PathParam("mdp") String pMdp) 
	{
		JsonObjectBuilder json = Json.createObjectBuilder();
		json.add("name", pName);
		
		if(!pName.equals("admin") || !pMdp.equals("admin")) 
		{
			json.add("authent", false);
		}
		else
		{
			json.add("authent", true);
			json.add("uuid", UUID.randomUUID().toString());
		}
		
		return json.build();
	}

}
