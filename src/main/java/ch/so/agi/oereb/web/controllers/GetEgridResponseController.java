package ch.so.agi.oereb.web.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.so.agi.oereb.web.domains.Egrid;
import ch.so.agi.oereb.web.services.EgridServiceImpl;
import ch.so.agi.oereb.web.xml.GetEGRIDResponseListType;
import ch.so.agi.oereb.web.xml.GetEGRIDResponseType;

@Component
@Path("/getegrid/xml/")
public class GetEgridResponseController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EgridServiceImpl egridService;

	/*
	@GET
	//@Produces(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_XML)
	public GetEGRIDResponseType helloMessage(@QueryParam("XY") String xy) {
		//return "Hello World Jersey Wady! " + xy;
		return egridService.getEgridByXY();
	}
	*/
	
	@GET
    @Produces(MediaType.APPLICATION_XML)
	public GetEGRIDResponseListType helloMessage(@QueryParam("XY") String xy) {
		return egridService.getEgrids();
	}

}
