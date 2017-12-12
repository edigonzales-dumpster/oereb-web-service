package ch.so.agi.oereb.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.so.agi.oereb.web.domains.EgridParcel;
import ch.so.agi.oereb.web.services.EgridServiceImpl;
import ch.so.agi.oereb.web.types.GetEGRIDResponseType;

@RestController
public class GetEGRIDResponseController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	private Environment env;
	
	@Autowired
	private EgridServiceImpl egridService;
	
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
				
		GetEGRIDResponseType getEGRIDResponseType = egridService.getEgridByXY(coords[0], coords[1]);
		
		if (getEGRIDResponseType.getEgridAndNumberAndIdentDN().size() == 0) {
			log.warn("No egrid found at: " + xy);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(egridService.getEgridByXY(coords[0], coords[1]));
	}
	
	@RequestMapping(value="/getegrid/{format:xml|json}/", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_XML_VALUE}, 
			params={"GNSS"})
	@ResponseBody
	public ResponseEntity<?> getEgridByGNSS (
			@PathVariable("format") String format,
			@RequestParam(value = "GNSS") String gnss) {
			
		double[] coords = validateCoordinateRequestParam(gnss);
				
		GetEGRIDResponseType getEGRIDResponseType = egridService.getEgridByGNSS(coords[0], coords[1]);
		
		if (getEGRIDResponseType.getEgridAndNumberAndIdentDN().size() == 0) {
			log.warn("No egrid found at: " + gnss);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(getEGRIDResponseType);
	}
	
	@RequestMapping(value="/getegrid/{format:xml|json}/{identdn}/{number}", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<?> getEgridByNumberAndIdentDN (
			@PathVariable("identdn") String identdn,
			@PathVariable("number") String number) {
		
		log.debug(identdn);
		log.debug(number);
		
		// TODO: Can this be done better/nicer?
		// Since the housing number is optional the "GetEgridByAddress"
		// request has only two path variables like this one. There is no way
		// to distinguish the two except some heuristic?!
		// If the identdn has only 4 digits, we assume it is not a
		// identdn but a postal code.
		if (identdn.length() == 4) {
			log.debug("IdentDN has only 4 digits. We assume it is a postalcode instead.");
			
			String postalcode = identdn;
			String localisation = number;
			
			//return ResponseEntity.ok(egridService.getEgridByPostalcodeAndLocalisation(postalcode, localisation));
			return ResponseEntity.ok(null);
		}
		
		GetEGRIDResponseType getEGRIDResponseType = egridService.getEgridByNumberAndIdentDN(number, identdn);
		
		if (getEGRIDResponseType.getEgridAndNumberAndIdentDN().size() == 0) {
			log.warn("No egrid found at: " + identdn + "/" + number);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return ResponseEntity.ok(egridService.getEgridByNumberAndIdentDN(number, identdn));
	}

	@RequestMapping(value="/getegrid/{format:xml|json}/{postalcode}/{localisation}/{number}", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<?> getEgridByAddress (
			@PathVariable("postalcode") String postalcode,
			@PathVariable("localisation") String localisation,
			@PathVariable("number") String number) {
		
		log.debug(postalcode);
		log.debug(localisation);
		log.debug(number);
		
		// TODO: implement
		//return ResponseEntity.ok(egridService.getEgridByPostalcodeAndLocalisationAndNumber(postalcode, localisation, number));
		return ResponseEntity.ok(null);
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
