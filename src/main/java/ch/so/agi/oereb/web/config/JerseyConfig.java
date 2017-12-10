package ch.so.agi.oereb.web.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import ch.so.agi.oereb.web.controllers.GetEGRIDResponseController;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(GetEGRIDResponseController.class);
	}
}
