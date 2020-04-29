package fr.ulille.iut.agile;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthentificationTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new
        // org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test if the JSON is correctly created.
     */
    @Test
    public void testAuthentification() {
        JsonObject responseJson1 = target.path("authent/admin/admin").request().get(JsonObject.class);
        assertEquals("admin", responseJson1.getString("name"));
        assertTrue(responseJson1.getBoolean("authent"));

        JsonObject responseJson2 = target.path("authent/truc/admin").request().get(JsonObject.class);
        assertEquals("truc", responseJson2.getString("name"));
        assertFalse(responseJson2.getBoolean("authent"));

        JsonObject responseJson3 = target.path("authent/admin/truc").request().get(JsonObject.class);
        assertFalse(responseJson3.getBoolean("authent"));

        JsonObject responseJson4 = target.path("authent/truc/truc").request().get(JsonObject.class);
        assertFalse(responseJson4.getBoolean("authent"));
    }

}
