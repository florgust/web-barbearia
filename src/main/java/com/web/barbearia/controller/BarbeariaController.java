package com.web.barbearia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.barbearia.model.Servicos;
import com.web.barbearia.repository.ServicosRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/barbearia")
@RequiredArgsConstructor
public class BarbeariaController {

    private static final Logger logger = LoggerFactory.getLogger(BarbeariaController.class);
    private final ServicosRepository servicosRepository;

    @GetMapping()
    public String barbearia(Model model) {
        logger.info("-- Entrou em barbearia");
        logger.info("-- Encaminhando para a view barbearia");
        List<Servicos> servicos = servicosRepository.findAll();
        model.addAttribute("barbearia", servicos);
        return "barbearia";
    }

}
