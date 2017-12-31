package ch.so.agi.oereb.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.so.agi.oereb.web.services.EgridServiceImpl;
import ch.admin.geo.schemas.v_d.oereb._1_0.extract.GetEGRIDResponseType;

@RestController
public class GetEGRIDResponseController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
    	
	@Autowired
	private EgridServiceImpl egridEntityService;
	
	//200: OK, Antwort konnte erstellt werden
	//204: Kein Grundstück gefunden 
	//500: Andere Fehler 
		
	@RequestMapping(value="/getegrid/{format:xml|json}/", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_XML_VALUE}, 
			params={"XY"})
	@ResponseBody
	public ResponseEntity<?> getEgridByXY (
			@PathVariable("format") String format,
			@RequestParam(value = "XY") String xy) {

		double[] coords = validateCoordinateRequestParam(xy);
				
		GetEGRIDResponseType getEGRIDResponseType = egridEntityService.getEgridByXY(coords[0], coords[1]);
		
		if (getEGRIDResponseType.getEgridAndNumberAndIdentDN().size() == 0) {
			log.warn("No egrid found at: " + xy);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(egridEntityService.getEgridByXY(coords[0], coords[1]));
		//return ResponseEntity.ok().body("adsf");
	}
	
	@RequestMapping(value="/getegrid/{format:xml|json}/", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_XML_VALUE}, 
			params={"GNSS"})
	@ResponseBody
	public ResponseEntity<?> getEgridByGNSS (
			@PathVariable("format") String format,
			@RequestParam(value = "GNSS") String gnss) {
			
		double[] coords = validateCoordinateRequestParam(gnss);
				
		GetEGRIDResponseType getEGRIDResponseType = egridEntityService.getEgridByGNSS(coords[0], coords[1]);
		
		if (getEGRIDResponseType.getEgridAndNumberAndIdentDN().size() == 0) {
			log.warn("No egrid found at: " + gnss);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(getEGRIDResponseType);
	}
		
	// TODO: improve regex
	@RequestMapping(value="/getegrid/{format:xml|json}/{identdn:.{12,12}}/{number}", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<?> getEgridByNumberAndIdentDN (
			@PathVariable("identdn") String identdn,
			@PathVariable("number") String number) {
		
		log.debug(identdn);
		log.debug(number);
				
		GetEGRIDResponseType getEGRIDResponseType = egridEntityService.getEgridByNumberAndIdentDN(number, identdn);
		
		if (getEGRIDResponseType.getEgridAndNumberAndIdentDN().size() == 0) {
			log.warn("No egrid found at: " + identdn + "/" + number);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(getEGRIDResponseType);
	}

	@RequestMapping(value="/getegrid/{format:xml|json}/{postalcode:[0-9]{4,4}}/{localisation}", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<?> getEgridByPostalcodeAndLocalisation (
			@PathVariable("postalcode") String postalcode,
			@PathVariable("localisation") String localisation) {
		
		log.debug(postalcode);
		log.debug(localisation);
				
		GetEGRIDResponseType getEGRIDResponseType = egridEntityService.getEgridByPostalcodeAndLocalisationAndNumber(postalcode, localisation, null);
		
		if (getEGRIDResponseType.getEgridAndNumberAndIdentDN().size() == 0) {
			log.warn("No egrid found at: " + postalcode + "/" + localisation);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(getEGRIDResponseType);
	}

	@RequestMapping(value="/getegrid/{format:xml|json}/{postalcode:[0-9]{4,4}}/{localisation}/{number}", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<?> getEgridByPostalcodeAndLocalisationAndNumber (
			@PathVariable("postalcode") String postalcode,
			@PathVariable("localisation") String localisation,
			@PathVariable("number") String number) {
		
		log.debug(postalcode);
		log.debug(localisation);
		log.debug(number);
				
		GetEGRIDResponseType getEGRIDResponseType = egridEntityService.getEgridByPostalcodeAndLocalisationAndNumber(postalcode, localisation, number);
		
		if (getEGRIDResponseType.getEgridAndNumberAndIdentDN().size() == 0) {
			log.warn("No egrid found at: " + postalcode + "/" + localisation + "/" + number);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(getEGRIDResponseType);
	}

	// For both coordinate request methods (XY, GNSS), 
	// the request parameter must be two doubles, separated with a comma.
	private double[] validateCoordinateRequestParam(String coordinate) {
		String[] parts = coordinate.split(",");
		if (parts.length != 2) {
			throw new IllegalArgumentException("Request parameter 'XY' not in correct format");
		}
		
		double[] coords = new double[2];
		coords[0] = Double.parseDouble(parts[0]);
		coords[1] = Double.parseDouble(parts[1]);

		return coords;
	}
	
	@ExceptionHandler({IllegalArgumentException.class, NumberFormatException.class})
	private ResponseEntity<?> handleBadRequests(Exception e) {
		log.error(e.getMessage());		
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
