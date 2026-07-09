package com.github.eventmaster_api.dto.response;

import com.github.eventmaster_api.domain.Inscricao;

import java.time.LocalDateTime;
import java.util.UUID;

public record InscricaoResponseDto(
        UUID id,
        EventoResponseDto evento,
        ParticipanteResponseDto participante,
        LocalDateTime dataInscricao
) {

    public static InscricaoResponseDto fromEntity(Inscricao inscricao) {
        return new InscricaoResponseDto(
                inscricao.getId(),
                EventoResponseDto.fromEntity(inscricao.getEvento()),
                ParticipanteResponseDto.fromEntity(inscricao.getParticipante()),
                inscricao.getDataInscricao()
        );
    }
}
