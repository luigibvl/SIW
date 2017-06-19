package it.uniroma3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
    @RequestMapping(value={"/","/welcome"})
    public String welcome(){
        return "welcome";
    }
  
    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }
   
    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }
   
    @RequestMapping(value={"/logout"})
    public String logout(){
        return "logout";
    }
    
    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
    
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
      model.addAttribute("loginError", true);
      return "login";
    }
    
    @RequestMapping(value="/galleria")
    public String gallery(){
        return "galleria";
    }
    
}