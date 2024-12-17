package com.web.barbearia.controller;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.barbearia.model.Atendimento;
import com.web.barbearia.model.Servicos;
import com.web.barbearia.service.AtendimentoService;
import com.web.barbearia.service.ServicosService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/agendar")
@RequiredArgsConstructor
public class AgendarController {

    private static final Logger logger = LoggerFactory.getLogger(AgendarController.class);
    private final ServicosService servicosService;
    private final AtendimentoService atendimentoService;

    @GetMapping()
    public String agendarForm(@RequestParam("id") Long id, Model model) {
        Servicos servico = servicosService.findById(id);
        model.addAttribute("servico", servico);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime inicioDaSemana = now
                .with(TemporalAdjusters.previousOrSame(WeekFields.of(Locale.getDefault()).getFirstDayOfWeek()))
                .withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime fimDaSemana = inicioDaSemana.plusDays(6).withHour(23).withMinute(59).withSecond(59)
                .withNano(999999999);

        List<Atendimento> agendamentos = atendimentoService.buscarAtendimentosPorSemana(inicioDaSemana, fimDaSemana);
        model.addAttribute("agendamentos", agendamentos);

        Map<String, List<String>> horariosOcupados = new HashMap<>();
        for (Atendimento atendimento : agendamentos) {
            String data = atendimento.getData().toLocalDate().toString();
            String horario = atendimento.getData().toLocalTime().toString();

            horariosOcupados
                    .computeIfAbsent(data, k -> new ArrayList<>())
                    .add(horario);
        }

        logger.info("Horarios Ocupados: {}", horariosOcupados);
        model.addAttribute("horariosOcupados", horariosOcupados);

        return "agendar/agendar";
    }

    @PostMapping("/criar")
    public String criar(@RequestParam("selectedDate") String selectedDate,
            @RequestParam("selectedTime") String selectedTime,
            @RequestParam("servicoId") Long servicoId) {
        atendimentoService.criar(selectedDate, selectedTime, servicoId);
        return "redirect:/barbearia";
    }
}
