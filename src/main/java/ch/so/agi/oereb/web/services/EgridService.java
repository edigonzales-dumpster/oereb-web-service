package ch.so.agi.oereb.web.services;

import ch.so.agi.oereb.web.types.GetEGRIDResponseType;

public interface EgridService {
	GetEGRIDResponseType getEgridByNumberAndIdentDN(String number, String identDN);
	
	GetEGRIDResponseType getEgridByXY(double easting, double northing);
	
	GetEGRIDResponseType getEgridByGNSS(double latitude, double longitude);

	GetEGRIDResponseType getEgridByPostalcodeAndLocalisationAndNumber(String postalcode, String localisation, String number);
}