package ch.so.agi.oereb.web.services;

import ch.admin.geo.schemas.v_d.oereb._1_0.extract.GetEGRIDResponseType;

public interface EgridService {
	GetEGRIDResponseType getGetEGRIDResponseTypeByNumberAndIdentDN(String number, String identDN);
	
	GetEGRIDResponseType getGetEGRIDResponseTypeByXY(double easting, double northing);
	
	GetEGRIDResponseType getGetEGRIDResponseTypeByGNSS(double latitude, double longitude);

	GetEGRIDResponseType getGetEGRIDResponseTypeByPostalcodeAndLocalisationAndNumber(String postalcode, String localisation, String number);
}