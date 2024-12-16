package com.web.barbearia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.barbearia.model.Servicos;
import com.web.barbearia.service.ServicosService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicosController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    private final ServicosService service;

    @GetMapping()
    public String servicos(Model model) {
        logger.info("-- Entrou em servicos");
        List<Servicos> servicos = service.findAll();
        logger.info("lista de servicos: {}", servicos);
        model.addAttribute("servicos_lista", servicos);
        logger.info("-- Encaminhando para a view servicos");
        return "servicos/servicos";
    }
    
    @GetMapping("/nova")
    public String novoServicoForm() {
        logger.info("Entrou em nova");
        return "servicos/criar_servicos";
    }

    @PostMapping("/nova")
    public String criarServico(Servicos servico) {
        logger.info("Entrou em nova/salvar");
        servico.setUrlImagem("images/padrao.webp");
        service.create(servico);
        return "redirect:/servicos";
    }

    @PostMapping("/remover")
    public String remover(Servicos servico) {
        service.delete(servico);
        return "redirect:/servicos";
    }
    
    
}
