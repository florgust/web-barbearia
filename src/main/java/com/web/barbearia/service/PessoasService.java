package com.web.barbearia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.web.barbearia.model.Pessoa;
import com.web.barbearia.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoasService {
    private static final Logger logger = LoggerFactory.getLogger(PessoasService.class);

    private final PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public void create(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public void editar(Pessoa pessoa) {
        Pessoa pessoaExistente = findById(pessoa.getCodigo());
        pessoaExistente.setNome(pessoa.getNome());
        pessoaExistente.setSenha(pessoa.getSenha());
        pessoaExistente.setNascimento(pessoa.getNascimento());
        pessoaExistente.setEmail(pessoa.getEmail());
        pessoaExistente.setTelefone(pessoa.getTelefone());
        pessoaExistente.setTipo(pessoa.getTipo());
        pessoaRepository.save(pessoaExistente);
    }

    public void delete(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
    }
}