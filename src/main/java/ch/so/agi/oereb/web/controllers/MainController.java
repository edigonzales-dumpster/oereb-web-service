package ch.so.agi.oereb.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.so.agi.oereb.web.domains.Egrid;
import ch.so.agi.oereb.web.services.EgridServiceImpl;

@Controller
public class MainController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	private Environment env;
	
	@Autowired
	private EgridServiceImpl egridService;
	 
	private final String[] outputFormats = {
			"xml", 
			"json"
	};

	@RequestMapping(value="/getegrid", method=RequestMethod.GET, produces = "application/xml")
	@ResponseBody
	public ResponseEntity<?> test() {
		String output = "fubar";
		return ResponseEntity
				.ok()
				.header("Content-Type", "text/plain; charset=utf-8")
				.contentLength(output.length())
				//.contentType(MediaType.parseMediaType("text/plain"))
				.body(output);	      

	}
	
	@RequestMapping(value="/getegrid/{format:xml|json}/", method=RequestMethod.GET,
			produces={MediaType.APPLICATION_XML_VALUE}, 
			params={"XY"})
	@ResponseBody
	public ResponseEntity<?> getEgridByXY(
	//public List<Egrid> getEgridByXY(
			@PathVariable("format") String format,
			@RequestParam(value = "XY") String xy) {
		
		
		// TODO: Do this in service method because we probably create two controllers, one 
		// for each output format.
		String[] parts = xy.split(",");
		log.info(String.valueOf(parts.length));
		if (parts.length != 2) {
			// TODO: response (siehe Weisung wegen Status-Code)
			// Spring Boot macht aus IllegalArgumentException ein 500 ohne Extras.
			throw new IllegalArgumentException("Request parameter 'XY' not in correct format");
		}
		
		// TODO: exception/response handling
		// NumberFormatException -> 500
		double easting = Double.parseDouble(parts[0]);
		double northing = Double.parseDouble(parts[1]);

		log.info(format);
		log.info(String.valueOf(easting));
		log.info(String.valueOf(northing));
		
        //List<Egrid> egridResponse=egridService.getEgridByXY();
        //return ResponseEntity.ok(egridResponse);
		
		Egrid myEgrid = new Egrid();
		myEgrid.setT_id(123L);
		myEgrid.setEgrid("CH12355");
		myEgrid.setIdentnd("Fubarxxx");
		myEgrid.setNumber("654");
		
		List<Egrid> egridList = new ArrayList<Egrid>();
		egridList.add(myEgrid);
		
		return ResponseEntity.ok(myEgrid);

		
		/*
		
		return ResponseEntity
				.ok()
				.header("Content-Type", "text/plain; charset=utf-8")
				.contentLength(format.length())
				//.contentType(MediaType.parseMediaType("text/plain"))
				.body(format);	 
		*/
	}

	
	
	
//	@RequestMapping(value="/getegrid/{format}/", method=RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<?> getegrid(
//			@PathVariable("format") String format,
//			@RequestParam(value = "XY", required = false) String xy,
//			@RequestParam(value = "GNSS", required = false) String gnss) {
//		
//		// Stop executing when requested output format is not available.
//		if (!Arrays.asList(outputFormats).contains(format)) {
//			String msg = "Wrong output format: " + format;
//			return ResponseEntity
//					.status(500)
//					.header("Content-Type", "text/plain; charset=utf-8")
//					.contentLength(msg.length())
//					.body(msg);	      
//		}
//		
//		// Stop executing when neither 'XY' nor 'GNSS' is set.
//		if (xy == null && gnss == null) {
//			String msg = "Missing input parameters.";
//			return ResponseEntity
//					.status(500)
//					.header("Content-Type", "text/plain; charset=utf-8")
//					.contentLength(msg.length())
//					.body(msg);	      
//		}
//		
//		
//		log.info(xy);
//		
//		return ResponseEntity
//				.ok()
//				.header("Content-Type", "text/plain; charset=utf-8")
//				.contentLength(format.length())
//				//.contentType(MediaType.parseMediaType("text/plain"))
//				.body(format);	      
//
//	}
}
