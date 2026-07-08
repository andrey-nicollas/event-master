package com.github.eventmaster_api.mapper;

import com.github.eventmaster_api.domain.Participante;
import com.github.eventmaster_api.dto.request.ParticipanteRequestDto;
import com.github.eventmaster_api.dto.response.ParticipanteResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ParticipanteMapper {

    public Participante toEntity(ParticipanteRequestDto participanteRequestDto) {
        Participante participante = new Participante();
        participante.setNome(participanteRequestDto.nome());
        participante.setEmail(participanteRequestDto.email());
        participante.setCpf(participanteRequestDto.cpf());
        return participante;
    }

    public ParticipanteResponseDto toResponse(Participante participante) {
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
