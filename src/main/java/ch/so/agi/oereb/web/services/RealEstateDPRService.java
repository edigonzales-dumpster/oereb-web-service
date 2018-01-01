package ch.so.agi.oereb.web.services;

import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RealEstateDPR;
import ch.so.agi.oereb.web.utils.WebMapServiceException;

public interface RealEstateDPRService {
	RealEstateDPR getRealEstateDPRByEgrid(String egrid) throws WebMapServiceException;
	
}
