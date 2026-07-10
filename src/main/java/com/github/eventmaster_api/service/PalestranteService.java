package com.github.eventmaster_api.service;

import com.github.eventmaster_api.dto.request.PalestranteRequestDto;
import com.github.eventmaster_api.dto.response.PalestranteResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PalestranteService {

    PalestranteResponseDto create(PalestranteRequestDto dto);

    PalestranteResponseDto update(UUID id, PalestranteRequestDto dto);

    PalestranteResponseDto findById(UUID id);

    Page<PalestranteResponseDto> findAll(Pageable pageable);
}
