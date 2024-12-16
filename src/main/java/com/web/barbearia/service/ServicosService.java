package com.web.barbearia.service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.web.barbearia.controller.ServiceController;
import com.web.barbearia.model.Servicos;
import com.web.barbearia.repository.ServicosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicosService {
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);

    private final ServicosRepository servicosRepository;

    public List<Servicos> findAll() {
        return servicosRepository.findAll();
    }

    public void create(Servicos servicos) {
        servicos.setUrlImagem("images/padrao.webp");
        servicos.setTempoDuracao(formatarTempo(servicos.getTempoDuracao()));
        servicosRepository.save(servicos);
    }

    private String formatarTempo(String tempo) {
        int minutos = Integer.parseInt(tempo);
        Duration duration = Duration.ofMinutes(minutos);
        LocalTime time = LocalTime.ofSecondOfDay(duration.getSeconds());
        return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void delete(Servicos servico) {
        servicosRepository.delete(servico);
    }
}
