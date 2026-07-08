package com.github.eventmaster_api.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ParticipanteResponseDto(
        UUID id,
        String nome,
        String email,
        String cpf,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {
}
