package it.uniroma3.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Authorities;
import it.uniroma3.model.Autore;
import it.uniroma3.model.Opera;
import it.uniroma3.model.Person;
import it.uniroma3.model.Users;
import it.uniroma3.repository.AuthorityRepository;
import it.uniroma3.repository.AutoreRepository;
import it.uniroma3.repository.OperaRepository;
import it.uniroma3.repository.PersonRepository;
import it.uniroma3.repository.UsersRepository;

@Service
public class PersonService {
	
	private PersonRepository repositoryPerson;
	private AutoreRepository repositoryAutore;
	private OperaRepository repositoryOpera;
	private UsersRepository repositoryUsers;
	private AuthorityRepository repositoryAuthority;
	
	@Autowired
	public PersonService(PersonRepository personRepository,AutoreRepository autoreRepository,OperaRepository repositoryOpera,UsersRepository repositoryUsers,AuthorityRepository repositoryAuthority) {
		this.repositoryPerson = personRepository;
		this.repositoryAutore=autoreRepository;
		this.repositoryOpera=repositoryOpera;
		this.repositoryUsers=repositoryUsers;
		this.repositoryAuthority=repositoryAuthority;
	}
	
	public void addPerson(Person p){
		
		
		this.repositoryPerson.save(p);
		
		
	}
	
	

	public List<Person> findALL(){
		List<Person> list=new ArrayList<>();
		
		list=(List<Person>) this.repositoryPerson.findAll();
		
		
		
		return list;
			
	}

	public void addAutore(Autore a) {
		// TODO Auto-generated method stub
		this.repositoryAutore.save(a);
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

	public void addUsers(Users u) {
		// TODO Auto-generated method stub
		
		this.repositoryUsers.save(u);
		
	}



	public void addAuthorities(Authorities auto) {
		// TODO Auto-generated method stub
		this.repositoryAuthority.save(auto);
	}

	


	


	
}
