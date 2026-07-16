package com.github.eventmaster_api.controller;

import com.github.eventmaster_api.dto.request.SalaRequestDto;
import com.github.eventmaster_api.dto.response.SalaResponseDto;
import com.github.eventmaster_api.service.SalaService;
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
@RequestMapping("/v1/eventemaster-api/salas")
@RequiredArgsConstructor
public class SalaController {

    private final SalaService salaService;

    @PostMapping
    public ResponseEntity<SalaResponseDto> create(@RequestBody @Valid SalaRequestDto dto) {
        var sala = salaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(sala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaResponseDto> update(@PathVariable UUID id,
                                                  @RequestBody @Valid SalaRequestDto dto) {
        var sala = salaService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(sala);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDto> findById(@PathVariable UUID id) {
        var sala = salaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(sala);
    }

    @GetMapping
    public ResponseEntity<Page<SalaResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable) {
        var sala = salaService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(sala);
    }
}
