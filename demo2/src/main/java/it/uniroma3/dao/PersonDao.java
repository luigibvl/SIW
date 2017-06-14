package it.uniroma3.dao;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.model.Person;

public class PersonDao {
	
	
	
	public Person find(){
		Person p=new Person("name2","last2",33);
		
		return p;
	}
	
	
	public List<Person> findAll(){
		List<Person> persons=new ArrayList<>();
		Person p=new Person("name","last",30);
		
		
		Person p1=new Person("name1","last2",32);
	
		persons.add(p);
		persons.add(p1);
		
		
		return persons;
	}
}
