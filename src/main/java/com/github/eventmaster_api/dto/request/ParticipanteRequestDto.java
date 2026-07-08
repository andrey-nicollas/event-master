package com.github.eventmaster_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ParticipanteRequestDto(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotBlank(message = "o email é obrigatório.")
        String email,

        @NotBlank(message = "O cpf é obrigatório.")
        String cpf
) {
}
