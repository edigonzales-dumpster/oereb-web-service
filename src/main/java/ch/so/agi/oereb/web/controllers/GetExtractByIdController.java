package ch.so.agi.oereb.web.controllers;

import java.net.MalformedURLException;

import javax.xml.datatype.DatatypeConfigurationException;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import ch.so.agi.oereb.web.services.ExtractService;
import ch.so.agi.oereb.web.utils.WMSServiceException;

@RestController
public class GetExtractByIdController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ExtractService extractService;

	// TODO: Optionales "pfad-element" (geometry)?
	// Optionale Path Variable gibt es, aber ist ja eigentlich 
	// keine Variable. Könnte man notfalls vielleicht verwenden,
	// um Code zu sparen. Einfach zwei values? Resp. Array o.ä.?
	
	// TODO: RequestParam mit beschränkter Auswahl? Regex? Lang, Topics
	
	// TODO: Wann params={}, wann RequestParam?
	
	// TODO: throw error if LANG != "de"
	
	@RequestMapping(value = {"/extract/{flavour:reduced|full|signed|embeddable}/{format:xml|json|pdf}/geometry/{egrid:.{14,14}}", 
			"/extract/{flavour:reduced|full|signed|embeddable}/{format:xml|json|pdf}/{egrid:.{14,14}}"}, 
			method=RequestMethod.GET,
			produces={MediaType.APPLICATION_XML_VALUE})
			//produces={MediaType.ALL_VALUE})
	@ResponseBody
	public ResponseEntity<?> getExtractByEgrid (
			@PathVariable("flavour") String flavour,
			@PathVariable("format") String format,
			@PathVariable("egrid") String egrid,
			@RequestParam(value = "LANG", required = false, defaultValue = "de") String lang,
			@RequestParam(value = "TOPIS", required = false, defaultValue = "ALL") String topics,
			@RequestParam(value = "WITHIMAGES", required = false) String images) 
					throws DatatypeConfigurationException, WMSServiceException {
		
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
        boolean withGeometry = builder.buildAndExpand().getPathSegments().contains("geometry");  // I want this.
        
		boolean withImages = true;
		if (images == null) {
			withImages = false;
		}
		
		StringBuilder outputMsg = new StringBuilder();
		outputMsg.append("\n");
		outputMsg.append("*****************************\n");
		outputMsg.append("FLAVOUR: " + flavour + "\n");
		outputMsg.append("FORMAT: " + format + "\n");
		outputMsg.append("EGRID: " + egrid + "\n");
		outputMsg.append("LANG: " + lang + "\n");
		outputMsg.append("TOPICS: " + topics + "\n");
		outputMsg.append("WITHIMAGES: " + withImages + "\n");
		outputMsg.append("GEOMETRY: " + withGeometry + "\n");
		log.info(outputMsg.toString());

		boolean isReduced = false;
		if (flavour.equalsIgnoreCase("reduced")) {
			isReduced = true;
		}
		
		return ResponseEntity.ok(extractService.getDummy(egrid, isReduced, withGeometry, withImages));
		//return ResponseEntity.ok().body(outputMsg.toString());
	}
	
	@ExceptionHandler({IllegalArgumentException.class, DatatypeConfigurationException.class,
		WMSServiceException.class})
	private ResponseEntity<?> handleBadRequests(Exception e) {
		log.error(e.getMessage());		
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
