package com.web.barbearia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.barbearia.model.Pessoa;
import com.web.barbearia.service.PessoasService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoasController {
    private static final Logger logger = LoggerFactory.getLogger(PessoasController.class);

    private final PessoasService service;

    @GetMapping()
    public String pessoas(Model model) {
        logger.info("-- Entrou em pessoas");
        List<Pessoa> pessoas = service.findAll();
        logger.info("lista de pessoas: {}", pessoas);
        model.addAttribute("pessoas_lista", pessoas);
        logger.info("-- Encaminhando para a view pessoas");
        return "pessoas/pessoas";
    }

    @GetMapping("/nova")
    public String novaPessoaForm(Model model) {
        logger.info("Entrou em nova");
        model.addAttribute("pessoa", new Pessoa());
        return "pessoas/criar_pessoas";
    }

    @PostMapping("/nova")
    public String criarPessoa(Pessoa pessoa) {
        logger.info("Entrou em nova/salvar");
        service.create(pessoa);
        return "redirect:/pessoas";
    }

    @GetMapping("/editar")
    public String editarPessoaForm(@RequestParam("id") Long id, Model model) {
        Pessoa pessoa = service.findById(id);
        model.addAttribute("pessoa", pessoa);
        return "pessoas/criar_pessoas";
    }

    @PostMapping("/editar")
    public String editarPessoa(Pessoa pessoa) {
        logger.info("Entrou em editar");
        service.editar(pessoa);
        return "redirect:/pessoas";
    }

    @PostMapping("/remover")
    public String remover(Pessoa pessoa) {
        service.delete(pessoa);
        return "redirect:/pessoas";
    }
}