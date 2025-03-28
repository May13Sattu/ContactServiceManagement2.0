package com.fortunetelllers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tempcontroller")
public class PageController {

    @GetMapping("/index")
    public String getMethod(Model model){
        System.out.println("Hello project building started");
        //Sending data to view
        model.addAttribute("name","Cantanct Management Services");
        model.addAttribute("Youtube", "Learning code with Sattu dada");
        return "index";
    }
}
