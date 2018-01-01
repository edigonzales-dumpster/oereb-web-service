package ch.so.agi.oereb.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vividsolutions.jts.geom.Polygon;

import ch.so.agi.oereb.web.domains.RestrictionOnLandownershipAreaEntity;

public interface RestrictionOnLandownershipAreaEntityRepository extends JpaRepository<RestrictionOnLandownershipAreaEntity, Long> {
    
	@Query(nativeQuery = true)
    List<RestrictionOnLandownershipAreaEntity> getRestrictionsByGeometry(@Param("limit") Polygon limit, @Param("land_registry_area") int landRegistryArea);
}
