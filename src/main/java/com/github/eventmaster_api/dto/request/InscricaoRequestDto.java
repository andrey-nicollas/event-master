package com.github.eventmaster_api.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record InscricaoRequestDto(

        @NotNull(message = "O evento é obrigatório.")
        UUID eventoId,

        @NotNull(message = "O participante é obrigatório.")
        UUID participanteId,

        @NotNull(message = "A data de inscrição é obrigatória.")
        LocalDateTime dataInscricao
) {
}
