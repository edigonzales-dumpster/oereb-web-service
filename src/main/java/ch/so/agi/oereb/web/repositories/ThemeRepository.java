package ch.so.agi.oereb.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vividsolutions.jts.geom.Polygon;

import ch.so.agi.oereb.web.domains.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
	
    @Query(nativeQuery = true)
	List<Theme> findThemesByGeometry(@Param("limit") Polygon limit);

}
