package com.github.eventmaster_api.service.impl;

import com.github.eventmaster_api.domain.Participante;
import com.github.eventmaster_api.dto.request.ParticipanteRequestDto;
import com.github.eventmaster_api.dto.response.ParticipanteResponseDto;
import com.github.eventmaster_api.repository.ParticipanteRepository;
import com.github.eventmaster_api.service.ParticipanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParticipanteServiceImpl implements ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    @Override
    @Transactional
    public ParticipanteResponseDto create(ParticipanteRequestDto dto) {

        if (participanteRepository.existsByCpf(dto.cpf())
                || participanteRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Já existe um participante cadastrado com esse email ou CPF.");
        }

        Participante participante = new Participante();
        participante.setNome(dto.nome());
        participante.setEmail(dto.email());
        participante.setCpf(dto.cpf());

        var participanteSalvo = participanteRepository.save(participante);
        return ParticipanteResponseDto.fromEntity(participanteSalvo);
    }

    @Override
    @Transactional
    public ParticipanteResponseDto update(UUID id, ParticipanteRequestDto dto) {

        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participante não encontrado."));

        if (!participante.getEmail().equals(dto.email()) && participanteRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Já existe um participante cadastrado com esse email.");

        }

        if (!participante.getCpf().equals(dto.cpf()) && participanteRepository.existsByCpf(dto.cpf())) {
            throw new RuntimeException("Já existe um participante cadastrado com esse CPF.");
        }

        participante.setNome(dto.nome());
        participante.setEmail(dto.email());
        participante.setCpf(dto.cpf());

        var participanteAtualizado = participanteRepository.save(participante);
        return ParticipanteResponseDto.fromEntity(participanteAtualizado);
    }

    @Override
    public ParticipanteResponseDto findById(UUID id) {
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participante não encontrado."));
        return ParticipanteResponseDto.fromEntity(participante);
    }

    @Override
    public Page<ParticipanteResponseDto> findAll(Pageable pageable) {
        return participanteRepository.findAll(pageable)
                .map(ParticipanteResponseDto::fromEntity);
    }
}
