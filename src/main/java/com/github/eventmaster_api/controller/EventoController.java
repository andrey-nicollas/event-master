package com.github.eventmaster_api.controller;

import com.github.eventmaster_api.dto.request.EventoRequestDto;
import com.github.eventmaster_api.dto.response.EventoResponseDto;
import com.github.eventmaster_api.service.EventoService;
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
@RequestMapping("/v1/eventemaster-api/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final EventoService eventoService;

    @PostMapping
    public ResponseEntity<EventoResponseDto> create(@RequestBody @Valid EventoRequestDto dto) {
        var evento = eventoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDto> update(@PathVariable UUID id,
                                                    @RequestBody @Valid EventoRequestDto dto) {
        var evento = eventoService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(evento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDto> findById(@PathVariable UUID id) {
        var evento = eventoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(evento);
    }

    @GetMapping
    public ResponseEntity<Page<EventoResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable) {
        var evento = eventoService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(evento);
    }
}
