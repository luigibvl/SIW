package it.uniroma3.dao;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.model.Person;

public class PersonDao {
	
	
	
	public Person find(){
		Person p=new Person();
		p.setFirstName("name1");
		p.setLastName("lastName1");
		p.setAge(30);
		return p;
	}
	
	
	public List<Person> findAll(){
		List<Person> persons=new ArrayList<>();
		Person p=new Person();
		p.setFirstName("name0");
		p.setLastName("lastName0");
		p.setAge(30);
		
		Person p1=new Person();
		p1.setFirstName("name11");
		p1.setLastName("lastName11");
		p1.setAge(30);
		persons.add(p);
		persons.add(p1);
		
		
		return persons;
	}
}
