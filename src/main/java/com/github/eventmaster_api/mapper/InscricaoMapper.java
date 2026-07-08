package com.github.eventmaster_api.mapper;

import com.github.eventmaster_api.domain.Inscricao;
import com.github.eventmaster_api.dto.request.InscricaoRequestDto;
import com.github.eventmaster_api.dto.response.InscricaoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InscricaoMapper {

    private final EventoMapper eventoMapper;
    private final ParticipanteMapper participanteMapper;


    public Inscricao toEntity(InscricaoRequestDto inscricaoRequestDto) {
        Inscricao inscricao = new Inscricao();
        inscricao.setDataInscricao(inscricaoRequestDto.dataInscricao());
        return inscricao;
    }

    public InscricaoResponseDto toResponse(Inscricao inscricao) {
        return new InscricaoResponseDto(
                inscricao.getId(),
                eventoMapper.toResponse(inscricao.getEvento()),
                participanteMapper.toResponse(inscricao.getParticipante()),
                inscricao.getDataInscricao()
        );
    }
}
