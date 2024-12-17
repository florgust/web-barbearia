package com.web.barbearia.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.barbearia.model.Atendimento;
import com.web.barbearia.model.Pessoa;
import com.web.barbearia.model.Servicos;
import com.web.barbearia.repository.AtendimentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtendimentoService {
    private final AtendimentoRepository atendimentoRepository;
    private final ServicosService servicosService;
    private final PessoasService pessoasService;

    public List<Atendimento> buscarAtendimentosPorSemana(LocalDateTime start, LocalDateTime end) {
        return atendimentoRepository.findByDataBetween(start, end);
    }

    public void criar(String date, String time, Long idServico) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate localDate = LocalDate.parse(formatString(date), dateFormatter);
        LocalTime localTime = LocalTime.parse(formatString(time), timeFormatter);

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Servicos servicos = servicosService.findById(idServico);
        Pessoa pessoa = pessoasService.findById(1L);

        Atendimento atendimento = new Atendimento();
        atendimento.setPessoa(pessoa);
        atendimento.setServico(servicos);
        atendimento.setData(localDateTime);
        atendimento.setValor(servicos.getPreco());

        atendimentoRepository.save(atendimento);
    }

    private String formatString(String source) {
        return source.replace(",", "");
    }
}
