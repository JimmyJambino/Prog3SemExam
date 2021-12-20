package com.example.prog3semexam.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //@GetMapping("/")
    public String index() {
        System.out.println("Home");
        return "index";
    }
}
