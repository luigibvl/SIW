package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.dao.PersonDao;
import it.uniroma3.model.Authorities;
import it.uniroma3.model.Autore;
import it.uniroma3.model.Opera;
import it.uniroma3.model.Person;
import it.uniroma3.model.Users;
import it.uniroma3.repository.PersonRepository;
import it.uniroma3.service.PersonService;

@Controller

public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}


	@ResponseBody
	@RequestMapping("/save")
	public String process(){

		Person p=new Person();
		p.setFirstName("Pier");
		p.setLastName("De Santi");
		p.setAge(23);

		this.personService.addPerson(p);

		return "Done";
	}

	@RequestMapping("/form")
	public String form(Model model){
		model.addAttribute(new Person());
		return "form";
	}

	@RequestMapping(value="processaForm",method=RequestMethod.POST)
	public String processaForm(@ModelAttribute Person p,Model model){
		this.personService.addPerson(p);
		model.addAttribute("person",p);
		return "resultForm";
	}

	@RequestMapping("/findAll")
	public String findAllPerson(ModelMap map){

		map.put("persons", this.personService.findALL());
		return "persons";

	}


	@RequestMapping(value="inserimentoAutore",method=RequestMethod.GET)
	public String inserisciAutore(Model model){
		model.addAttribute(new Autore());
		return "inserisciAutore";

	}

	@RequestMapping(value="processaAutore",method=RequestMethod.POST)
	public String processaAutore(@Valid @ModelAttribute Autore a,Model model,BindingResult bindingResult){


		if (bindingResult.hasErrors()) {
			return "inserisciAutore";
		}
		else {

			this.personService.addAutore(a);
			model.addAttribute("autore",a);
		}
		return "autoreView";
	}


	@RequestMapping(value="tornaApaginaInizialeAmministratore",method=RequestMethod.POST)
	public String tornaApaginaInizialeAmministratore(){
		return "paginaInizialeAmministratore";
	}

	@RequestMapping(value="inserimentoOpera",method=RequestMethod.GET)
	public String inserimentoOpera(ModelMap map){
		map.put("autori", this.personService.findAllAutors());

		return "listaAutori";
	}


	@RequestMapping(value="inserimentoDiUnOpera",method=RequestMethod.POST)
	public String inserimentoDiUnOpera(@RequestParam("idAutore") Long id,Model model){

		model.addAttribute("idAutore", id);
		model.addAttribute(new Opera());

		return "inserisciOpera";
	}

	@RequestMapping(value="eliminaAutore",method=RequestMethod.POST)
	public String eliminaAutore(@RequestParam("idAutore") Long id,Model model){

		Autore a=this.personService.getAutore(id);
		this.personService.cancellaAutore(a);

		model.addAttribute("autori",this.personService.findAllAutors());
		return "listaAutori";

	}


	@RequestMapping(value="processaOpera",method=RequestMethod.POST)
	public String processaOpera(@ModelAttribute Opera o,@RequestParam("idAutore") Long id,Model model){
		o.setAutore(this.personService.getAutore(id));
		this.personService.addOpera(o);
		model.addAttribute("opera", o);
		return "operaView";
	}


	@RequestMapping(value="listaOpereAutore",method=RequestMethod.POST)
	public String listaOpereAutore(@RequestParam("idAutore") Long id,Model model){
		List<Opera> opere=new ArrayList<>();
		opere=this.personService.getOpereAutore(id);

		model.addAttribute("opere", opere);


		return "opereAutore";

	}



	@RequestMapping(value="eliminaOpera",method=RequestMethod.POST)
	public String eliminaOpera(@RequestParam("idOpera") Long idOpera,@RequestParam("idAutore") Long idAutore,Model model){

		Opera opera=this.personService.getOpera(idOpera);
		this.personService.cancellaOpera(opera);

		model.addAttribute("opere",this.personService.getOpereAutore(idAutore));

		return "opereAutore";



	}

	@RequestMapping(value="registrazione",method=RequestMethod.POST)
	public String registrazione(Model model){
		model.addAttribute(new Users());

		return "registrazioneUtente";
	}


	@ResponseBody
	@RequestMapping(value="processaUsers",method=RequestMethod.POST)
	public String processaUsers(@ModelAttribute Users u,Model model){

		this.personService.addUsers(u);


		Authorities auto=new Authorities();
		auto.setUsername(u.getUsername());
		auto.setAuthority("utente_registrato");
		this.personService.addAuthorities(auto);


		return "utente registrato!";
	}


	//	@RequestMapping("/findById")
	//	public String findById(@RequestParam("id") long id){
	//		String result="";
	//		result=repository.findOne(id).toString();
	//		return result;
	//	}
	//	
	//	
	//	@RequestMapping("/findByLastName")
	//	public String findByLastName(@RequestParam("lastName") String lastName){
	//		String result="<html>";
	//		
	//		for(Person p:repository.findByLastName(lastName)){
	//			result+= "<div>" + p.toString()+ "</div>";
	//		}
	//		
	//		
	//		return result+"</html>";
	//	}




	//---------------------------------------




	@RequestMapping("/person")
	public String person(Model model){
		Person p=new Person();
		p.setFirstName("Pier");
		p.setLastName("De Santi");
		p.setAge(23);
		model.addAttribute("person", p);


		return "personview";
	}

	// pagina iniziale ----------------------	
	//	@RequestMapping("/")
	//	String entry(){
	//		return "paginaInizialeAmministratore";
	//	}

	//---------------------------------------------



	@RequestMapping("/NewFile")
	public String stampa1(){
		return "NewFile";
	}
	@RequestMapping(value="mappa",method=RequestMethod.GET)
	public String stampa3(ModelMap map){
		map.put("a","sopra la panca");
		map.put("b", 123);

		return "mappa";
	}


	@RequestMapping(value="persons",method=RequestMethod.GET)
	public String persons(ModelMap map){
		PersonDao dao=new PersonDao();
		map.put("persons", dao.findAll());

		return "persons";
	}

}
