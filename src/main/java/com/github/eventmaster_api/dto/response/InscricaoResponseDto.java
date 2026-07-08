package com.github.eventmaster_api.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record InscricaoResponseDto(
        UUID id,
        EventoResponseDto evento,
        ParticipanteResponseDto participante,
        LocalDateTime dataInscricao
) {
}
