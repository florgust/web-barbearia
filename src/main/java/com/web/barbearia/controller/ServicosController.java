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
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicosController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    private final ServicosRepository servicosRepository;

    @GetMapping("/criacao")
    public String servicos() {
        logger.info("-- Entrou em servicos");
        logger.info("-- Encaminhando para a view servicos");
        return "servicos";
    }

    @GetMapping("/getServicos")
    public String getServicos(Model model) {
        List<Servicos> servicos = servicosRepository.findAll();
        model.addAttribute("servicos", servicos);
        return "servicos";
    }
    
}
