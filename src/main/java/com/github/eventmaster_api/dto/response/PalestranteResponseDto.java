package com.github.eventmaster_api.dto.response;

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
}
