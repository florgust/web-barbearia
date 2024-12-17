package com.web.barbearia.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.barbearia.model.Pessoa;
import com.web.barbearia.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoasService {
    private static final Logger logger = LoggerFactory.getLogger(PessoasService.class);

    private final PessoaRepository pessoaRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public void create(Pessoa pessoa) {
        // Criptografa a senha antes de salvar
        if (pessoa.getSenha() != null && !pessoa.getSenha().isEmpty()) {
            pessoa.setSenha(passwordEncoder.encode(pessoa.getSenha()));
        }
        pessoaRepository.save(pessoa);
        logger.info("Nova pessoa criada com o email: {}", pessoa.getEmail());
    }

    public void editar(Pessoa pessoa) {
        Pessoa pessoaExistente = findById(pessoa.getCodigo());

        pessoaExistente.setNome(pessoa.getNome());
        pessoaExistente.setNascimento(pessoa.getNascimento());
        pessoaExistente.setEmail(pessoa.getEmail());
        pessoaExistente.setTelefone(pessoa.getTelefone());
        pessoaExistente.setTipo(pessoa.getTipo());

        // Verifica se uma nova senha foi fornecida e criptografa
        if (pessoa.getSenha() != null && !pessoa.getSenha().isEmpty()) {
            pessoaExistente.setSenha(passwordEncoder.encode(pessoa.getSenha()));
            logger.info("Senha atualizada para o usuário com o email: {}", pessoa.getEmail());
        }

        pessoaRepository.save(pessoaExistente);
        logger.info("Pessoa editada com sucesso. Email: {}", pessoaExistente.getEmail());
    }

    public void delete(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
        logger.info("Pessoa deletada com o email: {}", pessoa.getEmail());
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
    }
}
