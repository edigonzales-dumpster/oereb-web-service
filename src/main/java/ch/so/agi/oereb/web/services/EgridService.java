package ch.so.agi.oereb.web.services;

import java.util.List;

import ch.so.agi.oereb.web.domains.Egrid;
import ch.so.agi.oereb.web.types.GetEGRIDResponseType;
//import ch.so.agi.oereb.web.generated.GetEGRIDResponseListType;
//import ch.so.agi.oereb.web.generated.GetEGRIDResponseType;

public interface EgridService {
	
	//GetEGRIDResponseType getEgridByXY();
	
	GetEGRIDResponseType getEgrids();

	
	//Egrid getEgridByGNSS();
	
	//Egrid getEgridByIdentNDAndParcelNumber();
	
	//Egrid getEgridByAddress();
}