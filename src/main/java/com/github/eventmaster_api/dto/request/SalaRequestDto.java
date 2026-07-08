package com.github.eventmaster_api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaRequestDto(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotBlank(message = "A localização é obrigatório.")
        String localizacao,

        @NotNull(message = "A capacidado da sala é obrigatória.")
        @Min(value = 1, message = "A capacidade precisa ser de pelo menos 1 pessoa.")
        Integer capacidadeMaxima
) {
}
