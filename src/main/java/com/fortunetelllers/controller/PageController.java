package com.fortunetelllers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
        return "index";
    }

    // about page

    @GetMapping("/about")
    public String getAboutPage(Model model){
        model.addAttribute("isActive",false);
        System.out.println("About page is called");
        return "about"; // about page
    }

    // service page
    @GetMapping("/services")
    public String getSevicePage(Model model){ 
        System.out.println("Service page is called");
        //Sending data to view
        return "service"; // service page
    }
    
}
