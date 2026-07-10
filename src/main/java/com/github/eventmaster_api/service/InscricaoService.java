package com.github.eventmaster_api.service;

import com.github.eventmaster_api.dto.request.InscricaoRequestDto;
import com.github.eventmaster_api.dto.response.InscricaoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface InscricaoService {

    InscricaoResponseDto create(InscricaoRequestDto dto);

    InscricaoResponseDto update(UUID id, InscricaoRequestDto dto);

    InscricaoResponseDto findById(UUID id);

    Page<InscricaoResponseDto> findAll(Pageable pageable);
}
