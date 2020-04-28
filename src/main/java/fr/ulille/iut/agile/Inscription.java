package fr.ulille.iut.agile;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("register")
public class Inscription 
{
	@GET
	@Path("{name}/{mdp}/{email}")
	public JsonObject register(@PathParam("name") String pName, @PathParam("mdp") String pMdp, @PathParam("email") String pEmail) 
	{
		JsonObjectBuilder json = Json.createObjectBuilder();
		if(!emailIsCorrect(pEmail)) {
			json.add("register", false);
			return json.build();
		}
		
		new Utilisateur(pName, pMdp, pEmail);
		json.add("name", pName);
		json.add("register", true);
		json.add("uuid", UUID.randomUUID().toString());
		
		return json.build();
	}
	
	protected boolean emailIsCorrect(String pEmail) {
		String emailPattern = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailPattern);
		
		Matcher matcher = pattern.matcher(pEmail);
		return matcher.matches();
	}
	
}
