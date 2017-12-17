package ch.so.agi.oereb.web.controllers;

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

import ch.so.agi.oereb.web.services.ExtractService;

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
	
	@RequestMapping(value="/extract/{flavour:reduced|full|signed|embeddable}/{format:xml|json|pdf}/geometry/{egrid:.{14,14}}", 
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
			@RequestParam(value = "WITHIMAGES", required = false) String withImages) 
					throws DatatypeConfigurationException {
		
		log.info("*****************");
		log.info(withImages);
		if (withImages == null) {
			log.info("nicht requested");
		} else if (withImages.length() >= 0) {
			log.info("*** requested");
		}
		
		StringBuilder outputMsg = new StringBuilder();
		outputMsg.append("FLAVOUR: " + flavour + "\n");
		outputMsg.append("FORMAT: " + format + "\n");
		outputMsg.append("EGRID: " + egrid + "\n");
		outputMsg.append("LANG: " + lang + "\n");
		outputMsg.append("TOPICS: " + topics + "\n");
		outputMsg.append("WITHIMAGES: " + withImages + "\n");
		
		log.info(outputMsg.toString());

		return ResponseEntity.ok(extractService.getDummy(egrid));
		//return ResponseEntity.ok().body(outputMsg.toString());
	}
	
	@ExceptionHandler({IllegalArgumentException.class, DatatypeConfigurationException.class})
	private ResponseEntity<?> handleBadRequests(Exception e) {
		log.error(e.getMessage());		
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
