package com.github.eventmaster_api.service;

import com.github.eventmaster_api.dto.request.EventoRequestDto;
import com.github.eventmaster_api.dto.response.EventoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EventoService {

    EventoResponseDto create(EventoRequestDto dto);

    EventoResponseDto update(UUID id, EventoRequestDto dto);

    EventoResponseDto findById(UUID id);

    Page<EventoResponseDto> findAll(Pageable pageable);
}
