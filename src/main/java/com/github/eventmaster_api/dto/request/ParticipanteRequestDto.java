package com.github.eventmaster_api.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ParticipanteRequestDto(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotBlank(message = "o email é obrigatório.")
        String email,

        @NotBlank(message = "O cpf é obrigatório.")
        String cpf
) {
}
