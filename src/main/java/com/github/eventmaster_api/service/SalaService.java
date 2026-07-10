package com.github.eventmaster_api.service;

import com.github.eventmaster_api.dto.request.SalaRequestDto;
import com.github.eventmaster_api.dto.response.SalaResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface SalaService {

    SalaResponseDto create(SalaRequestDto dto);

    SalaResponseDto update(UUID id, SalaRequestDto dto);

    SalaResponseDto findById(UUID id);

    Page<SalaResponseDto> findAll(Pageable pageable);
}
