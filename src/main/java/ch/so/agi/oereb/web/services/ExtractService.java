package ch.so.agi.oereb.web.services;

import javax.xml.datatype.DatatypeConfigurationException;

import ch.admin.geo.schemas.v_d.oereb._1_0.extract.GetExtractByIdResponseType;

public interface ExtractService {
	GetExtractByIdResponseType getDummy(String egrid, boolean isReduced) throws DatatypeConfigurationException;
}
