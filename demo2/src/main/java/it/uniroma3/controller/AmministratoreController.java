package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.model.Amministratore;
import it.uniroma3.model.Authorities;
import it.uniroma3.model.Autore;
import it.uniroma3.model.Opera;
import it.uniroma3.model.Users;
import it.uniroma3.service.AmministratoreService;

@Controller
public class AmministratoreController {
	
	private final AmministratoreService amminstratoreSecvice;

	@Autowired
	public AmministratoreController(AmministratoreService personService) {
		this.amminstratoreSecvice = personService;
	}

	@RequestMapping(value="processaForm",method=RequestMethod.POST)
	public String processaForm(@ModelAttribute Amministratore p,Model model){
		this.amminstratoreSecvice.addAmministratore(p);
		model.addAttribute("person",p);
		return "resultForm";
	}

	@RequestMapping("/findAll")
	public String findAllPerson(ModelMap map){
		map.put("persons", this.amminstratoreSecvice.findALL());
		return "persons";
	}

	@RequestMapping(value="inserimentoAutore",method=RequestMethod.GET)
	public String inserisciAutore(Model model,Autore a){
		model.addAttribute(a);
		return "inserisciAutore";
	}

	@RequestMapping(value="processaAutore",method=RequestMethod.POST)
	public String processaAutore(@Valid @ModelAttribute Autore a,BindingResult result,
			Model model){

		if (result.hasErrors()) {
			return inserisciAutore(model,a);
		}
		else {
			this.amminstratoreSecvice.addAutore(a);
			model.addAttribute("autore",a);
		}
		return "autoreView";
	}
	
	@RequestMapping(value="admin",method=RequestMethod.POST)
	public String admin(){
		return "admin";
	}

	@RequestMapping(value="inserimentoOpera",method=RequestMethod.GET)
	public String inserimentoOpera(ModelMap map){
		map.put("autori", this.amminstratoreSecvice.findAllAutors());

		return "listaAutori";
	}

	@RequestMapping(value="inserimentoDiUnOpera",method=RequestMethod.POST)
	public String inserimentoDiUnOpera(@RequestParam("idAutore") Long id,Model model,Opera opera){

		model.addAttribute("idAutore",id);
		model.addAttribute(opera);

		return "inserisciOpera";
	}

	@RequestMapping(value="eliminaAutore",method=RequestMethod.POST)
	public String eliminaAutore(@RequestParam("idAutore") Long id,Model model){

		Autore a=this.amminstratoreSecvice.getAutore(id);
		this.amminstratoreSecvice.cancellaAutore(a);

		model.addAttribute("autori",this.amminstratoreSecvice.findAllAutors());
		return "listaAutori";

	}

	@RequestMapping(value="processaOpera",method=RequestMethod.POST)
	public String processaOpera(@Valid@ModelAttribute Opera o,BindingResult result,
			@RequestParam("idAutore") Long id,Model model){
		
		if (result.hasErrors()) {
			return inserimentoDiUnOpera(id,model,o);
		}
		else {
			o.setAutore(this.amminstratoreSecvice.getAutore(id));
			this.amminstratoreSecvice.addOpera(o);
			model.addAttribute("opera", o);
		}
		
		return "operaView";
	}

	@RequestMapping(value="listaOpereAutore",method=RequestMethod.POST)
	public String listaOpereAutore(@RequestParam("idAutore") Long id,Model model){
		
		List<Opera> opere=new ArrayList<>();
		opere=this.amminstratoreSecvice.getOpereAutore(id);
		model.addAttribute("opere", opere);

		return "opereAutore";
	}
	
	@RequestMapping(value="eliminaOpera",method=RequestMethod.POST)
	public String eliminaOpera(@RequestParam("idOpera") Long idOpera,@RequestParam("idAutore") Long idAutore,Model model){

		Opera opera=this.amminstratoreSecvice.getOpera(idOpera);
		this.amminstratoreSecvice.cancellaOpera(opera);
		model.addAttribute("opere",this.amminstratoreSecvice.getOpereAutore(idAutore));

		return "opereAutore";
	}

	@RequestMapping(value="registrazione",method=RequestMethod.POST)
	public String registrazione(Model model,Users u){
		
		model.addAttribute(u);
		return "registrazioneUtente";
	}

	
	@RequestMapping(value="processaUsers",method=RequestMethod.POST)
	public String processaUsers( @Valid @ModelAttribute Users u,
			BindingResult bindingResult,Model model){
		
		if (bindingResult.hasErrors()) {
			return registrazione(model,u);
		}
		
		else {
			
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

			String hashedPassword = passwordEncoder.encode(u.getPassword());
			Users user=new Users(u.getUsername(),u.getCognome(),u.getEta(),
					hashedPassword,u.getAuth());

			Authorities auth=new Authorities(user.getUsername(),"admin");
			user.setAuth(auth);
			Amministratore admin=new Amministratore(user.getUsername(),
					user.getCognome(),user.getEta());


			this.amminstratoreSecvice.addAuthorities(auth);
			this.amminstratoreSecvice.addUsers(user);

			//in questo caso sempre
			if(auth.getAuthority().equals("admin"))
				this.amminstratoreSecvice.addAmministratore(admin);
		}

		return "registrato";
	}

}
