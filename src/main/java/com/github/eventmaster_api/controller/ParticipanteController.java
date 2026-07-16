package com.github.eventmaster_api.controller;

import com.github.eventmaster_api.dto.request.ParticipanteRequestDto;
import com.github.eventmaster_api.dto.response.ParticipanteResponseDto;
import com.github.eventmaster_api.service.ParticipanteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/eventemaster-api/participantes")
@RequiredArgsConstructor
public class ParticipanteController {

    private final ParticipanteService participanteService;

    @PostMapping
    public ResponseEntity<ParticipanteResponseDto> create(@RequestBody @Valid ParticipanteRequestDto dto) {
        var participante = participanteService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(participante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteResponseDto> update(@PathVariable UUID id,
                                                          @RequestBody @Valid ParticipanteRequestDto dto) {
        var participante = participanteService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(participante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteResponseDto> findById(@PathVariable UUID id) {
        var participante = participanteService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(participante);
    }

    @GetMapping
    public ResponseEntity<Page<ParticipanteResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable) {
        var participante = participanteService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(participante);
    }
}
