package com.github.eventmaster_api.dto.response;

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
}
