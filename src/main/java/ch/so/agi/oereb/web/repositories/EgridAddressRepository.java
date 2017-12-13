package ch.so.agi.oereb.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.so.agi.oereb.web.domains.EgridAddress;

public interface EgridAddressRepository extends JpaRepository<EgridAddress, Long> {
	
	List<EgridAddress> getEgridByPostalcodeAndLocalisationAndHousingNumber(int postalcode, String localisation, String housingNumber);

	// TODO:
	// Either a better structure in the database.
	// Or other ways?
	// Btw: getDistinct... does not work since it is respecting the primary key (which is unique...).
	@Query("SELECT DISTINCT NEW ch.so.agi.oereb.web.domains.EgridAddress(e.egrid, e.identdn, e.number) FROM EgridAddress e WHERE e.postalcode = ?1 AND e.localisation = ?2")
	List<EgridAddress> getEgridByPostalcodeAndLocalisation(int postalcode, String localisation);
}
