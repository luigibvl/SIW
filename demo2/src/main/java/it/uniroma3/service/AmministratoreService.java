package it.uniroma3.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Authorities;
import it.uniroma3.model.Autore;
import it.uniroma3.model.Opera;
import it.uniroma3.model.Amministratore;
import it.uniroma3.model.Users;
import it.uniroma3.repository.AuthorityRepository;
import it.uniroma3.repository.AutoreRepository;
import it.uniroma3.repository.OperaRepository;
import it.uniroma3.repository.AmministratoreRepository;
import it.uniroma3.repository.UsersRepository;

@Service
public class AmministratoreService {
	
	private AmministratoreRepository repositoryAmministratore;
	private AutoreRepository repositoryAutore;
	private OperaRepository repositoryOpera;
	private UsersRepository repositoryUsers;
	private AuthorityRepository repositoryAuthority;
	
	@Autowired
	public AmministratoreService(AmministratoreRepository AmministratoreRepository,AutoreRepository autoreRepository,
			OperaRepository repositoryOpera,UsersRepository repositoryUsers,
			AuthorityRepository repositoryAuthority) {
		
		this.repositoryAmministratore = AmministratoreRepository;
		this.repositoryAutore=autoreRepository;
		this.repositoryOpera=repositoryOpera;
		this.repositoryUsers=repositoryUsers;
		this.repositoryAuthority=repositoryAuthority;
	}
	
	public void addAmministratore(Amministratore p){
		this.repositoryAmministratore.save(p);
	}
	
	public List<Amministratore> findALL(){
		
		List<Amministratore> list=new ArrayList<>();
		list=(List<Amministratore>) this.repositoryAmministratore.findAll();
		return list;	
	}

	public void addAutore(Autore a) {
		this.repositoryAutore.save(a);
	}
	
	public List<Autore> findAllAutors(){
		
		List<Autore> list=new ArrayList<>();
		list=(List<Autore>) this.repositoryAutore.findAll();
		return list;	
	}

	public Autore getAutore(Long id) {
		return this.repositoryAutore.findOne(id);
	}

	public void cancellaAutore(Autore a) {
		this.repositoryAutore.delete(a);
	}

	public void addOpera(Opera o) {
		this.repositoryOpera.save(o);
	}

	public List<Opera> getOpereAutore(Long id) {
		return this.getAutore(id).getOpere();
	}

	public Opera getOpera(Long id) {
		return this.repositoryOpera.findOne(id);
	}

	public void cancellaOpera(Opera opera) {
		this.repositoryOpera.delete(opera);
	}

	public void addUsers(Users u) {
		this.repositoryUsers.save(u);
	}	
	
	public void addAuthorities(Authorities auto) {
		this.repositoryAuthority.save(auto);
	}
	
}
