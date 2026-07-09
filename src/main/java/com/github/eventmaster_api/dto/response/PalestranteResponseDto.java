package com.github.eventmaster_api.dto.response;

import com.github.eventmaster_api.domain.Palestrante;

import java.time.LocalDateTime;
import java.util.UUID;

public record PalestranteResponseDto(

        UUID id,
        String nome,
        String email,
        String especialidade,
        String miniBiografia,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {

    public static PalestranteResponseDto fromEntity(Palestrante palestrante) {
        return new PalestranteResponseDto(
                palestrante.getId(),
                palestrante.getNome(),
                palestrante.getEmail(),
                palestrante.getEspecialidade(),
                palestrante.getMiniBiografia(),
                palestrante.getCriadoEm(),
                palestrante.getAtualizadoEm()
        );
    }
}
