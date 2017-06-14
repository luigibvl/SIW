package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.Amministratore;

@Repository
public interface AmministratoreRepository extends CrudRepository<Amministratore,Long> {
	List<Amministratore> findByLastName(String lastName);
	
}
