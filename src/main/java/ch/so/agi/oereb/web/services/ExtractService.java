package ch.so.agi.oereb.web.services;

import java.net.MalformedURLException;

import javax.xml.datatype.DatatypeConfigurationException;

import ch.admin.geo.schemas.v_d.oereb._1_0.extract.GetExtractByIdResponseType;
import ch.so.agi.oereb.web.utils.WebMapServiceException;

public interface ExtractService {
	GetExtractByIdResponseType getDummy(String egrid, boolean isReduced) throws DatatypeConfigurationException, WebMapServiceException;
}
