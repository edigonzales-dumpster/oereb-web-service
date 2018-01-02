package ch.so.agi.oereb.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ch.so.agi.oereb.web.domains.LegendEntryEntity;

public interface LegendEntryEntityRepository extends JpaRepository<LegendEntryEntity, Long> {
	
    @Query(nativeQuery = true)
	List<LegendEntryEntity> getLegendEntryEntityByRestrictionEntityId(@Param("t_id") int t_id);
}
