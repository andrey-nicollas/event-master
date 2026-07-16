package com.github.eventmaster_api.controller;

import com.github.eventmaster_api.dto.request.InscricaoRequestDto;
import com.github.eventmaster_api.dto.response.InscricaoResponseDto;
import com.github.eventmaster_api.service.InscricaoService;
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
@RequestMapping("/v1/eventemaster-api/inscricoes")
@RequiredArgsConstructor
public class InscricaoController {

    private final InscricaoService inscricaoService;

    @PostMapping
    public ResponseEntity<InscricaoResponseDto> create(@RequestBody @Valid InscricaoRequestDto dto) {
        var inscricao = inscricaoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscricaoResponseDto> update(@PathVariable UUID id,
                                                       @RequestBody @Valid InscricaoRequestDto dto) {
        var inscricao = inscricaoService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(inscricao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscricaoResponseDto> findById(@PathVariable UUID id) {
        var inscricao = inscricaoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(inscricao);
    }

    @GetMapping
    public ResponseEntity<Page<InscricaoResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable) {
        var inscricao = inscricaoService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(inscricao);
    }
}
