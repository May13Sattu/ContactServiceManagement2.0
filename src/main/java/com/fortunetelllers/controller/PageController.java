package com.fortunetelllers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fortunetelllers.entities.User;
import com.fortunetelllers.forms.UserForm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
@RequestMapping("/usersservice")
public class PageController {


    // home page
    @GetMapping("/home")
    public String getHomePage(Model model){
        System.out.println("Hello project building started");
        //Sending data to view
        model.addAttribute("name","Cantanct Management Services");
        model.addAttribute("Youtube", "Learning code with Sattu dada");
        return "home";
    }

    // about page

    @GetMapping("/about")
    public String getAboutPage(Model model){
        model.addAttribute("isActive",false);
        System.out.println("About page is called");
        return "about"; // about page
    }

    // service page
    @GetMapping("/service")
    public String getSevicePage(Model model){ 
        System.out.println("Service page is called");
        //Sending data to view
        return "service"; // service page
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "contact";
    }
    
    @GetMapping("/login")
    public String getLoginPage(){
        return "login"; // login page
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register"; // register page
    }

    @RequestMapping(value = "/do_registered", method=RequestMethod.POST)
    public String doRegistered(@ModelAttribute("userForm") UserForm userForm) {
        System.out.println("Processing registration for user: ");
        System.out.println(userForm);
        // UserForm userForm = new UserForm();
        // model.addAttribute("userForm", userForm);
        return "redirect:/usersservice/register"; // do_registered page
    }
    
}
