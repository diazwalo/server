package fr.ulille.iut.agile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.ulille.iut.agile.beans.Utilisateur;

@Path("register")
public class Inscription 
{
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	private static final String NAME_PATTERN = "^([a-zA-Z0-9-_]{2,36})$";
	
	@GET
	@Path("{name}/{mdp}/{email}")
	public JsonObject register(@PathParam("name") String pName, @PathParam("mdp") String pMdp, @PathParam("email") String pEmail) 
	{
		JsonObjectBuilder json = Json.createObjectBuilder();
		if(!patternIsCorrect(EMAIL_PATTERN, pEmail))
		{
			json.add("register", false);
			return json.build();
		}
		
		if(!patternIsCorrect(NAME_PATTERN, pName))
		{
			json.add("register", false);
			return json.build();
		}
		
		if(!patternIsCorrect(NAME_PATTERN, pMdp)) 
		{
			json.add("register", false);
			return json.build();
		}
		
		Utilisateur user = new Utilisateur(pName, pMdp, pEmail);
		json.add("name", pName);
		json.add("register", true);
		json.add("uuid", user.getIdentifiant());
		
		return json.build();
	}
	
	protected boolean patternIsCorrect(String pPattern, String pText)
	{
		Pattern pattern = Pattern.compile(pPattern);
		Matcher matcher = pattern.matcher(pText);
		return matcher.matches();
	}
	
}
