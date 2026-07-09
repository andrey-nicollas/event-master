package com.github.eventmaster_api.dto.response;

import com.github.eventmaster_api.domain.Sala;

import java.time.LocalDateTime;
import java.util.UUID;

public record SalaResponseDto(
        UUID id,
        String nome,
        String localizacao,
        Integer capacidadeMaxima,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {

    public static SalaResponseDto fromEntity(Sala sala) {
        return new SalaResponseDto(
                sala.getId(),
                sala.getNome(),
                sala.getLocalizacao(),
                sala.getCapacidadeMaxima(),
                sala.getCriadoEm(),
                sala.getAtualizadoEm()
        );
    }
}
