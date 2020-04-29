package fr.ulille.iut.agile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ping")
public class RequestPing extends Request {

	@GET
	@Path("{uuid}")
	public void ping(@PathParam("uuid") String pUUID) {
		update(pUUID);
	}
	
}
