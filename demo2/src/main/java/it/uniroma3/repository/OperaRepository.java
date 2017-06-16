package it.uniroma3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.Opera;

@Repository
public interface OperaRepository extends CrudRepository<Opera,Long>  {
	 			  
}
