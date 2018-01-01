package ch.so.agi.oereb.web.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.vividsolutions.jts.geom.Polygon;

import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;

public interface ThemeService {
	List<Theme> findConcernedThemesByGeometry(@Param("limit") Polygon limit);

	List<Theme> findNotConcernedThemesByGeometry(@Param("limit") Polygon limit);
	
	Theme getThemeObjectByIliCode(@Param("ilicode") String ilicode);
}
