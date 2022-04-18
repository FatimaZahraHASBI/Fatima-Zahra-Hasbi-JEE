package com.example.tp8_etud_spring_mvc_jpa_security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/403")
    public String notAuthorized(){
        return "403";
    }

    @GetMapping("/auth")
    public String login(){
        return "login";
    }
}
