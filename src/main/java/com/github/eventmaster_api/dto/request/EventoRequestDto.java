package com.github.eventmaster_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoRequestDto(

        @NotBlank(message = "O título é obrigatório.")
        String titulo,

        @NotBlank(message = "A descrição é obrigatória.")
        String descricao,

        @NotNull(message = "A data e hora de início é obrigatória.")
        LocalDateTime dataHoraInicio,

        @NotNull(message = "A data e hora de fim é obrigatória.")
        LocalDateTime dataHoraFim,

        @NotNull(message = "A sala é obrigatória.")
        UUID salaId,

        @NotNull(message = "O palestrante é obrigatório.")
        UUID palestranteId
) {
}
