package fr.ulille.iut.agile;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("users")
public class RequestUsers {

	@GET
	@Path("{uuid}/name")
	public JsonObject getNameByUUID(@PathParam("uuid") String pUUID)
	{
		JsonObjectBuilder json = Json.createObjectBuilder();
		json.add("name", "");
		
		return json.build();
	}
	
}
