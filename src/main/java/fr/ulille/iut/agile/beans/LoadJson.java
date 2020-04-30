package fr.ulille.iut.agile.beans;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import java.util.logging.Logger;

public class LoadJson {

	public static final LoadJson instance = new LoadJson();
	private static final Logger LOGGER = Logger.getLogger(LoadJson.class.getName());
	
	public void load() {
		JsonObject jsonVilles = jsonToStructure("res"+File.separator+"CoefSecuVille.json");
		if(jsonVilles != null) {
			loadListVilles(jsonVilles);
		}
	}
	
	private JsonObject jsonToStructure(String chemin) {
		JsonReader reader = null;
		try {
		    reader = Json.createReader(new FileReader(chemin));
		    JsonObject json = reader.readObject();
	        reader.close();
		    return json;
		} catch (IOException e) {
		    LOGGER.severe("Erreur de chargement");
		}
		return null;
	}
	
	private void loadListVilles(JsonObject pJson) {
		ListVilles list = ListVilles.instance;
		
		try {
			JsonArray villeArray = pJson.getJsonArray("Villes");
			int size = villeArray.size();
			for(int i=0; i<size; i++) {
				JsonObject villeObj = villeArray.getJsonObject(i);
				
				String name = villeObj.getString("name");
				float coef = villeObj.getInt("coef") / 100f;
				
				list.addVille(new Ville(name, coef));
			}
		} catch (Exception e) {
		    LOGGER.severe("Erreur de chargement");
		}
	}
	
}
