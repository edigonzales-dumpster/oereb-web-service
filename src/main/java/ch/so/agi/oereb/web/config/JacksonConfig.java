package ch.so.agi.oereb.web.config;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Needed for proper json output. 
 * TODO: some more info
 * TODO: does it work w/o crs?
 */

@Configuration
public class JacksonConfig {
    @Bean
    public JtsModule jtsModule() {
    	// We are bound to EPSG:2056.
    	// Not sure about the proper srid support in GeoJson?
    	// https://tools.ietf.org/html/rfc7946 -> chapter 4
    	GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(1000), 2056); 
        return new JtsModule(geometryFactory);
    }
}

