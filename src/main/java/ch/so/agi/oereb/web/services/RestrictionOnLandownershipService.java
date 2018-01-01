package ch.so.agi.oereb.web.services;

import java.util.List;

import com.vividsolutions.jts.geom.Polygon;

import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.RestrictionOnLandownership;

public interface RestrictionOnLandownershipService {
	List<RestrictionOnLandownership> getAreaRestrictionsByGeometry(Polygon limit, int landRegistryArea);
}
