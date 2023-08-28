package com.webapplication.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.webapplication.webapp.entities.User;

import com.webapplication.webapp.repo.UserRepository;



@Controller
public class HomeController {
   @Autowired 
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("title", "modified home page");
        return "home";
    }
    // about controller
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "smart contact about page");
        return "about";
    }
    // signup controller
      @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title", "smart contact registration page");
        model.addAttribute("user", new User());
        return "signup";
    }
    // handler for registering user 
   @PostMapping("/do_register")
    public String register(@ModelAttribute("user") User user, @RequestParam(value="agreement",defaultValue = "false") boolean agreement ,Model model ){
        
        try {
             
            user.setRole("user");
            user.setEnabled("true");
            user.setImageurl("default.png");
        
            System.out.println("Agreement "+ agreement);
            System.out.println("user"+user);

            model.addAttribute("user", user);

            if(agreement==true){
                User result=this.userRepository.save(user);

            }   

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        

        return "signup";
    }
}

