package com.github.eventmaster_api.service;

import com.github.eventmaster_api.dto.request.ParticipanteRequestDto;
import com.github.eventmaster_api.dto.response.ParticipanteResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ParticipanteService {

    ParticipanteResponseDto create(ParticipanteRequestDto dto);

    ParticipanteResponseDto update(UUID id, ParticipanteRequestDto dto);

    ParticipanteResponseDto findById(UUID id);

    Page<ParticipanteResponseDto> findAll(Pageable pageable);
}
