package fr.ulille.iut.agile;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;



public class Api extends ResourceConfig {
	public Api() {
		packages("fr.ulille.iut.agile");
		//register(LoggingFilter.class);s
		register(Authentification.class);
		register(RolesAllowedDynamicFeature.class);
	}
}
