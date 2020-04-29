package fr.ulille.iut.agile;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InscriptionTest {

    private HttpServer server;
    private WebTarget target;
    private Inscription inscription;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String NAME_PATTERN = "^([a-zA-Z0-9-_]{2,36})$";

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

        inscription = new Inscription();
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to check if the pattern of the name and the mail are correct.
     */
    @Test
    public void testPatternIsCorrect() {
        assertTrue(inscription.patternIsCorrect(EMAIL_PATTERN, "ad_min.ad-min@admin.fr"));
        assertFalse(inscription.patternIsCorrect(EMAIL_PATTERN, "admin.fr"));

        assertTrue(inscription.patternIsCorrect(NAME_PATTERN, "admIn_42"));
        assertFalse(inscription.patternIsCorrect(NAME_PATTERN, "a"));
        assertFalse(inscription.patternIsCorrect(NAME_PATTERN, "ad.min"));
    }
}
