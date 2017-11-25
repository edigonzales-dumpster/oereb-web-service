package ch.so.agi.oereb.web.controllers;

import java.util.Arrays;

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

@RestController
public class MainController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	private Environment env;
	 
	private final String[] outputFormats = {
			"xml", 
			"json"
	};

	@RequestMapping(value="/getegrid", method=RequestMethod.GET)
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
	
	@RequestMapping(value="/getegrid/{format:xml|json}/", method=RequestMethod.GET, params={"XY"})
	@ResponseBody
	public ResponseEntity<?> getEgridByXY(
			@PathVariable("format") String format,
			@RequestParam(value = "XY") String xy) {
		
		
		
		log.info(format);
		
		
		return ResponseEntity
				.ok()
				.header("Content-Type", "text/plain; charset=utf-8")
				.contentLength(format.length())
				//.contentType(MediaType.parseMediaType("text/plain"))
				.body(format);	 
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
