package com.github.eventmaster_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PalestranteRequestDto(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotBlank(message = "O email é obrigatório.")
        String email,

        @NotBlank(message = "A especialidade é obrigatória.")
        String especialidade,

        @NotBlank(message = "A mini biografia é obrigatória.")
        String miniBiografia
) {
}
