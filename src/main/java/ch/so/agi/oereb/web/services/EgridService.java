package ch.so.agi.oereb.web.services;

import java.util.List;

import ch.so.agi.oereb.web.domains.Egrid;

public interface EgridService {
	
	List<Egrid> getEgridByXY();
	
	//Egrid getEgridByGNSS();
	
	//Egrid getEgridByIdentNDAndParcelNumber();
	
	//Egrid getEgridByAddress();
}