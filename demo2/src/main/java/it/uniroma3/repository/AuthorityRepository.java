package it.uniroma3.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Authorities;
import it.uniroma3.model.Autore;

public interface AuthorityRepository extends CrudRepository<Authorities,Long>{

}
