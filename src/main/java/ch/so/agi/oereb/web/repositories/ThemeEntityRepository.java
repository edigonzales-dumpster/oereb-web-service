package ch.so.agi.oereb.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vividsolutions.jts.geom.Polygon;

import ch.so.agi.oereb.web.domains.ThemeEntity;

public interface ThemeEntityRepository extends JpaRepository<ThemeEntity, Long> {
	
    @Query(nativeQuery = true)
	List<ThemeEntity> findThemesByGeometry(@Param("limit") Polygon limit);

    @Query(nativeQuery = true)
    ThemeEntity getThemeByIliCode(@Param("ilicode") String ilicode);
}
