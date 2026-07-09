package com.github.eventmaster_api.dto.response;

import com.github.eventmaster_api.domain.Participante;

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

    public static ParticipanteResponseDto fromEntity(Participante participante) {
        return new ParticipanteResponseDto(
                participante.getId(),
                participante.getNome(),
                participante.getEmail(),
                participante.getCpf(),
                participante.getCriadoEm(),
                participante.getAtualizadoEm()
        );
    }
}
