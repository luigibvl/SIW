package it.uniroma3.dao;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.model.Amministratore;

public class AmministratoreDao {
	
	
	
	public Amministratore find(){
		Amministratore p=new Amministratore("name2","last2",33);
		return p;
	}
	
	
	public List<Amministratore> findAll(){
		
		List<Amministratore> persons=new ArrayList<>();
		Amministratore p=new Amministratore("name","last",30);
		Amministratore p1=new Amministratore("name1","last2",32);
		persons.add(p);
		persons.add(p1);
		
		return persons;
	}
}
