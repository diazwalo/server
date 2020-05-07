package fr.ulille.iut.agile.beans;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class LoadJson {

	public static final LoadJson instance = new LoadJson();
	private static final Logger LOGGER = Logger.getLogger(LoadJson.class.getName());

	private JsonObject jsonMeteo;

	public void load() {
		JsonObject jsonVilles = jsonToStructure("res" + File.separator + "CoefSecuVille.json");
		if (jsonVilles != null) {
			loadListVilles(jsonVilles);
		}
		loadMeteo();
	}

	public void loadMeteo() {
		if(jsonMeteo == null)  {
			if((jsonMeteo = jsonToStructure("res" + File.separator + "meteo.json")) == null) return;
		}
		
		JsonArray villeArray = jsonMeteo.getJsonArray("villes");
		int size = villeArray.size();
		
		for(int i = 0; i<size; i++) {
			JsonObject objVille = villeArray.getJsonObject(i);
			String name = objVille.getString("name");
			
			JsonObject objMeteo = objVille.getJsonObject("meteo");
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			LocalDate oldDate = null;
			List<String> tmp = new ArrayList<String>();
			
			for(String key: objMeteo.keySet()) {
				LocalDateTime date = null;
				try {
					date = LocalDateTime.parse(key, format);
				} catch(DateTimeParseException e) {
					continue;
				}
				
				if(oldDate == null) oldDate = date.toLocalDate();
				
				if(oldDate.equals(date.toLocalDate())) {
					oldDate = date.toLocalDate();
					tmp.add(key);
					continue;
				} else if(!dayIsFull(tmp)) {
					oldDate = date.toLocalDate();
					tmp.clear();
					tmp.add(key);
					continue;
				}
				
				Meteo meteo = new Meteo(oldDate);
				
				for(String s: tmp) {
					LocalDateTime dateTime = LocalDateTime.parse(s, format);
					JsonObject objDate = objMeteo.getJsonObject(s);
					
					double temperature = objDate.getJsonObject("temperature").getJsonNumber("sol").doubleValue();
					
					int pluie = (int) objDate.getJsonNumber("pluie").doubleValue() * 100;
					int pluieConvective = (int) (objDate.getJsonNumber("pluie_convective").doubleValue() * 100);
					double precipitation = (pluie + pluieConvective) / 100.0;
					boolean averse = pluieConvective > 0;
					
					meteo.addTemperature(dateTime, temperature);
					meteo.addPluie(dateTime, precipitation, averse);
				}
				
				ListVilles.instance.addMeteoTo(name, meteo);
				
				oldDate = date.toLocalDate();
				tmp.clear();
				tmp.add(key);
			}
		}
	}
	
	private boolean dayIsFull(List<String> pList) {
		return pList.size() == 8;
	}

	private JsonObject jsonToStructure(String chemin) {
		JsonReader reader = null;
		try {
			reader = Json.createReader(new FileReader(chemin));
			JsonObject json = reader.readObject();
			reader.close();
			return json;
		} catch (Exception e) {
			LOGGER.severe("LoadJson - Erreur de lecture");
		}
		return null;
	}

	private void loadListVilles(JsonObject pJson) {
		ListVilles list = ListVilles.instance;

		JsonArray villeArray = pJson.getJsonArray("villes");
		int size = villeArray.size();
		for (int i = 0; i < size; i++) {
			JsonObject villeObj = villeArray.getJsonObject(i);

			String name = villeObj.getString("name");
			double coef = villeObj.getJsonNumber("coef").doubleValue();
			String url_api = villeObj.getString("url_api");

			Ville myVille = new Ville(name);
			myVille.setCoefSecu(coef);
			myVille.setUrl_api(url_api);

			list.addVille(myVille);
		}
	}

}
