package com.github.eventmaster_api.dto.response;

import com.github.eventmaster_api.domain.Evento;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResponseDto(
        UUID id,
        String titulo,
        String descricao,
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFim,
        SalaResponseDto sala,
        PalestranteResponseDto palestrante,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {

    public static  EventoResponseDto fromEntity(Evento evento) {
        return new EventoResponseDto(
                evento.getId(),
                evento.getTitulo(),
                evento.getDescricao(),
                evento.getDataHoraInicio(),
                evento.getDataHoraFim(),
                SalaResponseDto.fromEntity(evento.getSala()),
                PalestranteResponseDto.fromEntity(evento.getPalestrante()),
                evento.getCriadoEm(),
                evento.getAtualizadoEm()
        );
    }
}
