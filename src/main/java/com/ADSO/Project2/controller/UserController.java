package com.ADSO.Project2.controller;

import com.ADSO.Project2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ADSO.Project2.Service.UserServices;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    @Autowired
    private UserServices userRepository;

    @GetMapping("/register/new")
    public String FormRegister(Model model){
        model.addAttribute("Users", new User());
        return "fragments/register";
    }

    @PostMapping("/registro")
    public String CreateUser(@ModelAttribute User User){
        userRepository.SaveUser(User);
        return "pages/index";
    }

    @GetMapping("/registro")
    public String ListRegister(Model model){
        model.addAttribute("result", userRepository.GetAllUsers());
        return "pages/index";
    }
     @GetMapping("/index")
    public String index(){
        return "pages/index";
    }
    @GetMapping("/users")
        public String users(){
        return "pages/users";
    }

    @GetMapping("/registro")
        public String registro(){
        return "pages/register";
    }

    @GetMapping("/login")
    public String login(){
        return "pages/login";
    }



}