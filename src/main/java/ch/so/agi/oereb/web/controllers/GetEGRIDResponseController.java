package ch.so.agi.oereb.web.controllers;

import java.util.List;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.so.agi.oereb.web.domains.Egrid;
import ch.so.agi.oereb.web.types.GetEGRIDResponseType;
import ch.so.agi.oereb.web.services.EgridServiceImpl;

//@Component
//@Path("/getegrid/xml/")
public class GetEGRIDResponseController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EgridServiceImpl egridService;
	
//	@GET
//    @Produces(MediaType.APPLICATION_XML)
//	public GetEGRIDResponseType helloMessage(@QueryParam("XY") String xy) {
//		return egridService.getEgrids();
//	}

}
