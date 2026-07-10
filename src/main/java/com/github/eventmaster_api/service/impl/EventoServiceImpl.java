package com.github.eventmaster_api.service.impl;

import com.github.eventmaster_api.domain.Evento;
import com.github.eventmaster_api.domain.Palestrante;
import com.github.eventmaster_api.domain.Sala;
import com.github.eventmaster_api.dto.request.EventoRequestDto;
import com.github.eventmaster_api.dto.response.EventoResponseDto;
import com.github.eventmaster_api.repository.EventoRepository;
import com.github.eventmaster_api.repository.PalestranteRepository;
import com.github.eventmaster_api.repository.SalaRepository;
import com.github.eventmaster_api.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventoServiceImpl implements EventoService {

    private final EventoRepository eventoRepository;
    private final SalaRepository salaRepository;
    private final PalestranteRepository palestranteRepository;

    @Override
    @Transactional
    public EventoResponseDto create(EventoRequestDto dto) {

        Sala sala = salaRepository.findById(dto.salaId())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada."));

        Palestrante palestrante = palestranteRepository.findById(dto.palestranteId())
                .orElseThrow(() -> new RuntimeException("Palestrante não encontrado."));

        Evento evento = new Evento();
        evento.setTitulo(dto.titulo());
        evento.setDescricao(dto.descricao());
        evento.setDataHoraInicio(dto.dataHoraInicio());
        evento.setDataHoraFim(dto.dataHoraFim());
        evento.setSala(sala);
        evento.setPalestrante(palestrante);

        var eventoSalvo = eventoRepository.save(evento);
        return EventoResponseDto.fromEntity(eventoSalvo);
    }

    @Override
    @Transactional
    public EventoResponseDto update(UUID id, EventoRequestDto dto) {

        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        Sala sala = salaRepository.findById(dto.salaId())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada."));

        Palestrante palestrante = palestranteRepository.findById(dto.palestranteId())
                .orElseThrow(() -> new RuntimeException("Palestrante não encontrado."));

        evento.setTitulo(dto.titulo());
        evento.setDescricao(dto.descricao());
        evento.setDataHoraInicio(dto.dataHoraInicio());
        evento.setDataHoraFim(dto.dataHoraFim());
        evento.setSala(sala);
        evento.setPalestrante(palestrante);

        var eventoAtualizado = eventoRepository.save(evento);
        return EventoResponseDto.fromEntity(eventoAtualizado);
    }

    @Override
    public EventoResponseDto findById(UUID id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado."));
        return EventoResponseDto.fromEntity(evento);
    }

    @Override
    public Page<EventoResponseDto> findAll(Pageable pageable) {
        return eventoRepository.findAll(pageable)
                .map(EventoResponseDto::fromEntity);
    }
}
