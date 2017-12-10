package ch.so.agi.oereb.web.services;

import java.util.List;

import ch.so.agi.oereb.web.domains.Egrid;
import ch.so.agi.oereb.web.xml.GetEGRIDResponseListType;
import ch.so.agi.oereb.web.xml.GetEGRIDResponseType;

public interface EgridService {
	
	GetEGRIDResponseType getEgridByXY();
	
	GetEGRIDResponseListType getEgrids();

	
	//Egrid getEgridByGNSS();
	
	//Egrid getEgridByIdentNDAndParcelNumber();
	
	//Egrid getEgridByAddress();
}