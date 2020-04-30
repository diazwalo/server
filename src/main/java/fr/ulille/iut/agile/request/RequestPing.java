package fr.ulille.iut.agile.request;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ping")
public class RequestPing implements Request {

	@GET
	@Path("{uuid}")
	public void ping(@PathParam("uuid") String pUUID) {
		update(pUUID);
	}
	
}
