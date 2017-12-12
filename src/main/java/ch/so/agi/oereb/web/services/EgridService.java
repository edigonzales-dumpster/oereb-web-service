package ch.so.agi.oereb.web.services;

import java.util.List;

import com.vividsolutions.jts.geom.Point;

import ch.so.agi.oereb.web.domains.EgridParcel;
import ch.so.agi.oereb.web.types.GetEGRIDResponseType;
//import ch.so.agi.oereb.web.generated.GetEGRIDResponseListType;
//import ch.so.agi.oereb.web.generated.GetEGRIDResponseType;

public interface EgridService {
	
	GetEGRIDResponseType getEgridByNumberAndIdentDN(String number, String identDN);
	
	GetEGRIDResponseType getEgridByXY(double easting, double northing);
	
	GetEGRIDResponseType getEgridByGNSS(double latitude, double longitude);

	
	GetEGRIDResponseType getEgrids();

	
	//Egrid getEgridByGNSS();
	
	//Egrid getEgridByIdentNDAndParcelNumber();
	
	//Egrid getEgridByAddress();
}