package fr.ulille.iut.agile.beans;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

public class ApiMeteo {

	public static ApiMeteo instance = new ApiMeteo();
	private static final Logger LOGGER = Logger.getLogger(LoadJson.class.getName());

	private static final int COOLDOWN = 1 * 1000; // En millisecondes
	private static final int DELAY = 1 * 60 * 60 * 1000; // En heures
	private static final int HOURS_DELAY = 1; // En heures
	private static final String PATH = "res" + File.separator + "meteo.json";

	private Thread delayRequest;
	private Thread cooldownRequest;

	private ApiMeteo() {}

	public void start() {
		delayRequest = new Thread() {
			@Override
			public void run() {
				while (true) {
					request();
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						LOGGER.severe("API METEO - Erreur de thread - Delay");
					}
				}

			}
		};

		delayRequest.start();
	}

	private void request() {
		JsonObject obj = readFile();
		if (obj == null || canRefresh(obj)) {
			JsonWriter writer = createFile();
			write(writer);
			LoadJson.instance.loadMeteo();
		}
	}

	private String readStream(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader r = new BufferedReader(new InputStreamReader(is), 1000);
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			sb.append(line);
		}
		is.close();
		return sb.toString();
	}

	private boolean canRefresh(JsonObject pJson) {
		try {
			String sDate = pJson.getString("date");
			LocalDateTime date = LocalDateTime.parse(sDate);

			if (date.until(LocalDateTime.now(), ChronoUnit.HOURS) >= HOURS_DELAY)
				return true;
			return false;
		} catch (Exception e) {
			LOGGER.severe("API METEO - Erreur de lecture");
		}
		return true;
	}

	private JsonObject readFile() {
		JsonReader reader = null;
		try {
			reader = Json.createReader(new FileInputStream(PATH));
			JsonObject obj = reader.readObject();
			reader.close();
			return obj;
		} catch (Exception e) {
			return null;
		}
	}

	private JsonWriter createFile() {
		JsonWriter writer = null;
		try {
			writer = Json.createWriter(new FileOutputStream(PATH));
		} catch (FileNotFoundException e) {
			LOGGER.severe("API METEO - Erreur de fichier");
		}
		return writer;
	}

	private void write(JsonWriter pJsonWriter) {
		JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		addDate(objBuilder);
		addInfosMeteo(objBuilder);

		JsonObject obj = objBuilder.build();
		pJsonWriter.writeObject(obj);
	}

	private void addInfosMeteo(JsonObjectBuilder pObjBuilder) {
		ListVilles listVilles = ListVilles.instance;
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		cooldownRequest = new Thread() {
			@Override
			public void run() {
				for (Ville myVille : listVilles) {
					JsonObject obj = getInfosByURL(myVille.getUrl_api());
					
					JsonObjectBuilder objBuilder = Json.createObjectBuilder();
					objBuilder.add("name", myVille.getName());
					if (obj != null) {
						objBuilder.add("empty", false);
						objBuilder.add("meteo", obj);
					} else {
						objBuilder.add("empty", true);
						objBuilder.add("meteo", "null");
					}
					arrayBuilder.add(objBuilder.build());
					
					try {
						Thread.sleep(COOLDOWN);
					} catch (InterruptedException e) {
						LOGGER.fine("API METEO - Fin requete");
					}
				}
				JsonArray array = arrayBuilder.build();
				pObjBuilder.add("villes", array);
				;
				cooldownRequest.interrupt();
			}
		};
		cooldownRequest.start();
		while (!cooldownRequest.isInterrupted());
	}

	private JsonObject getInfosByURL(String pURL) {
		HttpURLConnection connection = null;
		JsonReader reader = null;
		try {
			URL url = new URL(pURL);
			connection = (HttpURLConnection) url.openConnection();

			String redirect = connection.getHeaderField("Location");
			if (redirect != null) {
				connection = (HttpURLConnection) new URL(redirect).openConnection();
			}
			connection.connect();

			InputStream stream = new BufferedInputStream(connection.getInputStream());
			String result = readStream(stream);
			reader = Json.createReader(new StringReader(result));
			return reader.readObject();
		} catch (Exception e) {
			if (connection != null)
				connection.disconnect();
			if (reader != null)
				reader.close();
			return null;
		}
	}

	private void addDate(JsonObjectBuilder pObjBuilder) {
		LocalDateTime date = LocalDateTime.now();
		pObjBuilder.add("date", date.toString());
	}

}
