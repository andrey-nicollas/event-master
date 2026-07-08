package com.github.eventmaster_api.dto.response;

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
}
