package com.web.barbearia.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/default")
    public String defaultAfterLogin(Principal principal) {
        // Role-Based Redirect
        if (principal.getName().equals("admin")) {
            return "redirect:/admin/home";
        }
        return "redirect:/user/home";
    }
}
