package fr.ulille.iut.agile.request;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("{sendByUUID}/users")
public class RequestUsers extends Request {

	@GET
	@Path("{uuid}/name")
	public JsonObject getNameByUUID(@PathParam("sendByUUID") String sendBy, @PathParam("uuid") String pUUID)
	{
		update(pUUID);
		
		JsonObjectBuilder json = Json.createObjectBuilder();
		json.add("name", "");
		
		return json.build();
	}
	
}
