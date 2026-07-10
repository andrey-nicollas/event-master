package com.github.eventmaster_api.service.impl;

import com.github.eventmaster_api.domain.Evento;
import com.github.eventmaster_api.domain.Inscricao;
import com.github.eventmaster_api.domain.Participante;
import com.github.eventmaster_api.dto.request.InscricaoRequestDto;
import com.github.eventmaster_api.dto.response.InscricaoResponseDto;
import com.github.eventmaster_api.repository.EventoRepository;
import com.github.eventmaster_api.repository.InscricaoRepository;
import com.github.eventmaster_api.repository.ParticipanteRepository;
import com.github.eventmaster_api.service.InscricaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InscricaoServiceImpl implements InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final EventoRepository eventoRepository;
    private final ParticipanteRepository participanteRepository;

    @Override
    @Transactional
    public InscricaoResponseDto create(InscricaoRequestDto dto) {

        Evento evento = eventoRepository.findById(dto.eventoId())
                .orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        Participante participante = participanteRepository.findById(dto.participanteId())
                .orElseThrow(() -> new RuntimeException("Participante não encontrado."));

        Inscricao inscricao = new Inscricao();
        inscricao.setEvento(evento);
        inscricao.setParticipante(participante);
        inscricao.setDataInscricao(dto.dataInscricao());

        var inscricaoSalva = inscricaoRepository.save(inscricao);
        return InscricaoResponseDto.fromEntity(inscricaoSalva);
    }

    @Override
    @Transactional
    public InscricaoResponseDto update(UUID id, InscricaoRequestDto dto) {

        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscrição não encontrada."));

        Evento evento = eventoRepository.findById(dto.eventoId())
                .orElseThrow(() -> new RuntimeException("Evento não encontrado."));

        Participante participante = participanteRepository.findById(dto.participanteId())
                .orElseThrow(() -> new RuntimeException("Participante não encontrado."));

        inscricao.setEvento(evento);
        inscricao.setParticipante(participante);
        inscricao.setDataInscricao(dto.dataInscricao());

        var inscricaoAtualizada = inscricaoRepository.save(inscricao);
        return InscricaoResponseDto.fromEntity(inscricaoAtualizada);
    }

    @Override
    public InscricaoResponseDto findById(UUID id) {
        Inscricao inscricao = inscricaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscrição não encontrada."));
        return InscricaoResponseDto.fromEntity(inscricao);
    }

    @Override
    public Page<InscricaoResponseDto> findAll(Pageable pageable) {
        return inscricaoRepository.findAll(pageable)
                .map(InscricaoResponseDto::fromEntity);
    }
}
