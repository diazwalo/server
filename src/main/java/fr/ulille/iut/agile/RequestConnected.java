package fr.ulille.iut.agile;

import java.util.UUID;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.ulille.iut.agile.beans.ListConnected;

@Path("connected")
public class RequestConnected extends Request {

	@GET
	@Path("{uuid}")
	public JsonObject isConnected(@PathParam("uuid") String pUUID) {
		ListConnected myList = ListConnected.instance;
		UUID myUUID = UUID.fromString(pUUID);
		
		JsonObjectBuilder json = Json.createObjectBuilder();
		
		if(myList.isConnected(myUUID)) {
			json.add("connected", true);
		} else {
			json.add("connected", false);
			myList.removeConnected(myUUID);
		}
		
		return json.build();
	}
	
}
