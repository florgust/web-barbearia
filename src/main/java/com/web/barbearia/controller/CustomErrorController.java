package com.web.barbearia.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // A página 404.html será exibida automaticamente quando ocorrer um erro 404
        return "404"; // Nome do arquivo HTML
    }
}