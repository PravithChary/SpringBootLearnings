package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String home(){
        System.out.println("This is home page!");
        return "home";
    }

    @RequestMapping("/contact")
    public String contact(){
        System.out.println("This is the contact page!");
        return "contact";
    }

    @RequestMapping("/info")
    public String info(){
        System.out.println("Here are my details!");
        return "info";
    }
}
