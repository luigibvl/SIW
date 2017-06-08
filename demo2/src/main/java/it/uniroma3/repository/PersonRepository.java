package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
	List<Person> findByLastName(String lastName);
	
}
