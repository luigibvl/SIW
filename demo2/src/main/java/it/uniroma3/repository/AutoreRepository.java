package it.uniroma3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.Autore;

@Repository
public interface AutoreRepository extends CrudRepository<Autore,Long>  {
	 			  
}
