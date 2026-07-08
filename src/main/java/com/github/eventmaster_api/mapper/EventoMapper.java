package com.github.eventmaster_api.mapper;

import com.github.eventmaster_api.domain.Evento;
import com.github.eventmaster_api.dto.request.EventoRequestDto;
import com.github.eventmaster_api.dto.response.EventoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventoMapper {

    private final SalaMapper salaMapper;
    private final PalestranteMapper palestranteMapper;

    public Evento toEntity(EventoRequestDto eventoRequestDto) {
        Evento evento = new Evento();
        evento.setTitulo(eventoRequestDto.titulo());
        evento.setDescricao(eventoRequestDto.descricao());
        evento.setDataHoraInicio(eventoRequestDto.dataHoraInicio());
        evento.setDataHoraFim(eventoRequestDto.dataHoraFim());
        return evento;
    }

    public EventoResponseDto toResponse(Evento evento) {
        return new EventoResponseDto(
                evento.getId(),
                evento.getTitulo(),
                evento.getDescricao(),
                evento.getDataHoraInicio(),
                evento.getDataHoraFim(),
                salaMapper.toResponse(evento.getSala()),
                palestranteMapper.toResponse(evento.getPalestrante()),
                evento.getCriadoEm(),
                evento.getAtualizadoEm()
        );
    }
}
