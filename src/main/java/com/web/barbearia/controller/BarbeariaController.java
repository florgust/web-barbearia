package com.web.barbearia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/barbearia")
public class BarbeariaController {

    private static final Logger logger = LoggerFactory.getLogger(BarbeariaController.class);

    @GetMapping()
    public String barbearia() {
        logger.info("-- Entrou em barbearia");
        logger.info("-- Encaminhando para a view barbearia");
        return "barbearia";
    }

}
