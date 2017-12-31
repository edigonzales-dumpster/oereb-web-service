package ch.so.agi.oereb.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ch.so.agi.oereb.web.domains.RealEstateDPREntity;;

// TODO: gibt es etwas wie "find only first oder one"?
public interface RealEstateDPREntityRepository extends JpaRepository<RealEstateDPREntity, Long> {

    @Query(nativeQuery = true)
	RealEstateDPREntity findOneByEgrid(@Param("egrid") String egrid);

}
