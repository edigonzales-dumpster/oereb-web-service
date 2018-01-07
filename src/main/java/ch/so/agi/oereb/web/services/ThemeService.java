package ch.so.agi.oereb.web.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.vividsolutions.jts.geom.Polygon;

import ch.admin.geo.schemas.v_d.oereb._1_0.extractdata.Theme;

public interface ThemeService {
	List<Theme> getThemeByEgrid(String egrid, boolean isConcerned);

//	List<Theme> findNotConcernedThemesByGeometry(Polygon limit);
	
	Theme getThemeByIliCode(String ilicode);
}
