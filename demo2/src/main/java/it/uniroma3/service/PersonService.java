package it.uniroma3.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Opera;
import it.uniroma3.model.Person;
import it.uniroma3.repository.AutoreRepository;
import it.uniroma3.repository.OperaRepository;
import it.uniroma3.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository repositoryPerson;
	private AutoreRepository repositoryAutore;
	private OperaRepository repositoryOpera;
	
	@Autowired
	public PersonService(PersonRepository personRepository,AutoreRepository autoreRepository,OperaRepository repositoryOpera) {
		this.repositoryPerson = personRepository;
		this.repositoryAutore=autoreRepository;
		this.repositoryOpera=repositoryOpera;
	}
	
	public void addPerson(Person p){
		
		
		repositoryPerson.save(p);
		
		
	}
	
	

	public List<Person> findALL(){
		List<Person> list=new ArrayList<>();
		
		list=(List<Person>) this.repositoryPerson.findAll();
		
		
		
		return list;
			
	}

	public void addAutore(Autore a) {
		// TODO Auto-generated method stub
		repositoryAutore.save(a);
	}
	
	public List<Autore> findAllAutors(){
		List<Autore> list=new ArrayList<>();
		
		list=(List<Autore>) this.repositoryAutore.findAll();
		
		
		
		return list;
			
	}

	public Autore getAutore(Long id) {
		// TODO Auto-generated method stub
		
		return this.repositoryAutore.findOne(id);
	}

	public void cancellaAutore(Autore a) {
		// TODO Auto-generated method stub
		this.repositoryAutore.delete(a);
	}

	public void addOpera(Opera o) {
		// TODO Auto-generated method stub
		this.repositoryOpera.save(o);
		
	}

	public List<Opera> getOpereAutore(Long id) {
		// TODO Auto-generated method stub
		return this.getAutore(id).getOpere();
		
	}

	public Opera getOpera(Long id) {
		// TODO Auto-generated method stub
		return this.repositoryOpera.findOne(id);
	}

	public void cancellaOpera(Opera opera) {
		// TODO Auto-generated method stub
		this.repositoryOpera.delete(opera);
	}

	


	


	
}
