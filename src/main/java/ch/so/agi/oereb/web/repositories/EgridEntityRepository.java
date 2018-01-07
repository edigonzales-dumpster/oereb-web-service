package ch.so.agi.oereb.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vividsolutions.jts.geom.Point;

import ch.so.agi.oereb.web.domains.EgridEntity;

public interface EgridEntityRepository extends JpaRepository<EgridEntity, Long> {
	
    @Query(nativeQuery = true)
	List<EgridEntity> getEgridEntityByNumberAndIdentdn(@Param("number") String number, @Param("identdn") String identdn);

    @Query(nativeQuery = true)
	List<EgridEntity> getEgridEntityByXY(@Param("point") Point point);
    
    @Query(nativeQuery = true)
	List<EgridEntity> getEgridEntityByGNSS(@Param("point") Point point);
    
    @Query(nativeQuery = true)
    List<EgridEntity> getEgridEntityByPostalcodeAndLocalisationAndHousingNumber(@Param("postalcode") int postalcode, 
    		@Param("localisation") String localisation, @Param("housing_number") String housing_number);
    
    @Query(nativeQuery = true)
    List<EgridEntity> getEgridEntityByPostalcodeAndLocalisation(@Param("postalcode") int postalcode, 
    		@Param("localisation") String localisation);    
}
