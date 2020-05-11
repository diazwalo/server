package fr.ulille.iut.agile;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("carbon")
public class Carbon {

	@GET
	@Path("{surfaceMur}")
	public JsonObject GetCarbon(@PathParam("surfaceMur") String pSurface) {
		JsonObjectBuilder json = Json.createObjectBuilder();
		try {
			double surface = Double.parseDouble(pSurface);
			double co2 = surface * 2.3;
			double oxygen = surface * 1.7;
			json.add("co2", co2);
			json.add("oxygen", oxygen);
		} catch(Exception e) {
			json.add("value", "parametre incorrecte");
		}
		return json.build();
	}
	
}
