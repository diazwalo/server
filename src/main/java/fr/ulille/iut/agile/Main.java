package fr.ulille.iut.agile;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import fr.ulille.iut.agile.beans.ApiMeteo;
import fr.ulille.iut.agile.beans.LoadJson;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class.
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://0.0.0.0:8080/api/v1/";
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in fr.ulille.iut.agile package
        ResourceConfig rc = new ResourceConfig().packages("fr.ulille.iut.agile");
        rc.register(CORSFilter.class);
        //rc.register(new LoggingFeature(LOGGER, LoggingFeature.Verbosity.PAYLOAD_TEXT));
        rc.register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.ALL, LoggingFeature.Verbosity.PAYLOAD_TEXT, Integer.MAX_VALUE));
        LOGGER.info("Main");
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        
        startApiMeteo();
        loadRessource();
        
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
    
    private static void loadRessource() {
    	LoadJson.instance.load();
    }
    
    private static void startApiMeteo() {
    	ApiMeteo.instance.start();
    }

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at " + "%sapplication.wadl", BASE_URI));
        Thread.currentThread().join();
        server.shutdownNow();
    }
}

