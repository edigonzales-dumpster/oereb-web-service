package ch.so.agi.oereb.web.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ch.so.agi.oereb.web.domains.Egrid;

// TODO: create a read-only repo
// TODO: do not use paging. At the moment just for developing.
// TODO: This is Spring Boot magic. 

public interface EgridRepository extends PagingAndSortingRepository<Egrid, Long> {
	List<Egrid> findByEgrid(@Param("egrid") String egrid);
}
