package com.github.eventmaster_api.service.impl;

import com.github.eventmaster_api.domain.Sala;
import com.github.eventmaster_api.dto.request.SalaRequestDto;
import com.github.eventmaster_api.dto.response.SalaResponseDto;
import com.github.eventmaster_api.repository.SalaRepository;
import com.github.eventmaster_api.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;

    @Override
    @Transactional
    public SalaResponseDto create(SalaRequestDto dto) {
        Sala sala = new Sala();
        sala.setNome(dto.nome());
        sala.setLocalizacao(dto.localizacao());
        sala.setCapacidadeMaxima(dto.capacidadeMaxima());

        var salaSalva = salaRepository.save(sala);
        return SalaResponseDto.fromEntity(salaSalva);
    }

    @Override
    @Transactional
    public SalaResponseDto update(UUID id, SalaRequestDto dto) {

        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada."));

        sala.setNome(dto.nome());
        sala.setLocalizacao(dto.localizacao());
        sala.setCapacidadeMaxima(dto.capacidadeMaxima());

        var salaAtualizada = salaRepository.save(sala);
        return SalaResponseDto.fromEntity(salaAtualizada);
    }

    @Override
    public SalaResponseDto findById(UUID id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada."));
        return SalaResponseDto.fromEntity(sala);
    }

    @Override
    public Page<SalaResponseDto> findAll(Pageable pageable) {
        return salaRepository.findAll(pageable)
                .map(SalaResponseDto::fromEntity);
    }
}
