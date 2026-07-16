package com.github.eventmaster_api.controller;

import com.github.eventmaster_api.dto.request.PalestranteRequestDto;
import com.github.eventmaster_api.dto.response.PalestranteResponseDto;
import com.github.eventmaster_api.service.PalestranteService;
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
@RequestMapping("/v1/eventemaster-api/palestrantes")
@RequiredArgsConstructor
public class PalestranteController {

    private final PalestranteService palestranteService;

    @PostMapping
    public ResponseEntity<PalestranteResponseDto> create(@RequestBody @Valid PalestranteRequestDto dto) {
        var palestrante = palestranteService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(palestrante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PalestranteResponseDto> update(@PathVariable UUID id,
                                                         @RequestBody @Valid PalestranteRequestDto dto) {
        var palestrante = palestranteService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(palestrante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PalestranteResponseDto> findById(@PathVariable UUID id) {
        var palestrante = palestranteService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(palestrante);
    }

    @GetMapping
    public ResponseEntity<Page<PalestranteResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable) {
        var palestrante = palestranteService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(palestrante);
    }
}
