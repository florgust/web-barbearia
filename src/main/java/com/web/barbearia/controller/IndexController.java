package com.web.barbearia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping
    public String loginPage() {
        logger.info("-- Acessando a página de login");
        return "index"; // Retorna a view index.html
    }

    @PostMapping
    public String login() {
        logger.info("-- Login realizado com sucesso, redirecionando para a página da barbearia");
        return "redirect:/barbearia"; // Redireciona para a página da barbearia
    }
}
