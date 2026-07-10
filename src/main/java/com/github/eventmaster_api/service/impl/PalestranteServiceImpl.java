package com.github.eventmaster_api.service.impl;

import com.github.eventmaster_api.domain.Palestrante;
import com.github.eventmaster_api.dto.request.PalestranteRequestDto;
import com.github.eventmaster_api.dto.response.PalestranteResponseDto;
import com.github.eventmaster_api.repository.PalestranteRepository;
import com.github.eventmaster_api.service.PalestranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PalestranteServiceImpl implements PalestranteService {

    private final PalestranteRepository palestranteRepository;

    @Override
    @Transactional
    public PalestranteResponseDto create(PalestranteRequestDto dto) {

        if (palestranteRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Já existe um palestrante cadastrado com esse email.");
        }

        Palestrante palestrante = new Palestrante();
        palestrante.setNome(dto.nome());
        palestrante.setEmail(dto.email());
        palestrante.setEspecialidade(dto.especialidade());
        palestrante.setMiniBiografia(dto.miniBiografia());

        var palestranteSalvo = palestranteRepository.save(palestrante);
        return PalestranteResponseDto.fromEntity(palestranteSalvo);
    }

    @Override
    @Transactional
    public PalestranteResponseDto update(UUID id, PalestranteRequestDto dto) {

        Palestrante palestrante = palestranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Palestrante não encontrado."));

        if (!palestrante.getEmail().equals(dto.email()) && palestranteRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Já existe um palestrante cadastrado com esse email.");
        }

        palestrante.setNome(dto.nome());
        palestrante.setEmail(dto.email());
        palestrante.setEspecialidade(dto.especialidade());
        palestrante.setMiniBiografia(dto.miniBiografia());

        var palestranteAtualizado = palestranteRepository.save(palestrante);
        return PalestranteResponseDto.fromEntity(palestranteAtualizado);
    }

    @Override
    public PalestranteResponseDto findById(UUID id) {
        Palestrante palestrante = palestranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Palestrante não encontrado."));
        return PalestranteResponseDto.fromEntity(palestrante);
    }

    @Override
    public Page<PalestranteResponseDto> findAll(Pageable pageable) {
        return palestranteRepository.findAll(pageable)
                .map(PalestranteResponseDto::fromEntity);
    }
}
