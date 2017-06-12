package it.uniroma3.controller;
//controller 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
	@RequestMapping("/")
	String entry(){
		return "paginaInizialeAmministratore";
	}

	
	  @RequestMapping("/login")
	  public String login() {
	    return "login";
	  }

	
	  @RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login";
	  }

}
