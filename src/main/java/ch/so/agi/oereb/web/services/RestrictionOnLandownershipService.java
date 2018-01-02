package ch.so.agi.oereb.web.services;

import java.util.List;

import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RestrictionOnLandownership;
import ch.so.agi.oereb.web.domains.RealEstateDPREntity;
import ch.so.agi.oereb.web.utils.WMSServiceException;

public interface RestrictionOnLandownershipService {
	List<RestrictionOnLandownership> getAreaRestrictionsByRealEstateDPREntity(RealEstateDPREntity realEstateDPREntity, boolean withGeometry) throws WMSServiceException;
}
