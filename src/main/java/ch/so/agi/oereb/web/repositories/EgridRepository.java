package ch.so.agi.oereb.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vividsolutions.jts.geom.Point;

import ch.so.agi.oereb.web.domains.Egrid;

public interface EgridRepository extends JpaRepository<Egrid, Long> {
	
    @Query(nativeQuery = true)
	List<Egrid> findByNumberAndIdentdn(@Param("number") String number, @Param("identdn") String identdn);

    @Query(nativeQuery = true)
	List<Egrid> findByXY(@Param("point") Point point);
    
    @Query(nativeQuery = true)
	List<Egrid> findByGNSS(@Param("point") Point point);
    
    @Query(nativeQuery = true)
    List<Egrid> getEgridByPostalcodeAndLocalisationAndHousingNumber(@Param("postalcode") int postalcode, 
    		@Param("localisation") String localisation, @Param("housing_number") String housing_number);
    
    @Query(nativeQuery = true)
    List<Egrid> getEgridByPostalcodeAndLocalisation(@Param("postalcode") int postalcode, 
    		@Param("localisation") String localisation);    
}
