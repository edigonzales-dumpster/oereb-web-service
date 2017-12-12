package ch.so.agi.oereb.web.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vividsolutions.jts.geom.Point;

import ch.so.agi.oereb.web.domains.EgridParcel;

// TODO: create a read-only repo
// TODO: This is Spring Boot magic. 

public interface EgridParcelRepository extends JpaRepository<EgridParcel, Long> {
	
	// TODO: why use (or use not) "@Param()"?
	List<EgridParcel> findByNumberAndIdentdn(String number, String identdn);

    @Query("SELECT e FROM EgridParcel e WHERE intersects(e.geometrie, ?1) = true")
	List<EgridParcel> findByXY(Point p);
    
    @Query("SELECT e FROM EgridParcel e WHERE intersects(e.geometrie, function('ST_Transform', ?1, 2056)) = true")
	List<EgridParcel> findByGNSS(Point p);
}
