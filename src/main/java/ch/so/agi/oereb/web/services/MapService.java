package ch.so.agi.oereb.web.services;

import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Map;
import ch.so.agi.oereb.web.domains.RealEstateDPREntity;
import ch.so.agi.oereb.web.domains.RestrictionOnLandownershipEntity;
import ch.so.agi.oereb.web.utils.WMSServiceException;

public interface MapService {
	Map getMapByRestrictionEntityAndRealEstateDPREntity(RestrictionOnLandownershipEntity restrictionEntity, RealEstateDPREntity realEstateDPREntity, boolean withGeometry) throws WMSServiceException;
	
//	Map getPlanForLandRegister();
	
//	Map getPlanForLandRegisterMainPage();
}
