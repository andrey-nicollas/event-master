package com.github.eventmaster_api.mapper;

import com.github.eventmaster_api.domain.Sala;
import com.github.eventmaster_api.dto.request.SalaRequestDto;
import com.github.eventmaster_api.dto.response.SalaResponseDto;
import org.springframework.stereotype.Component;

@Component
public class SalaMapper {

    public Sala toEntity(SalaRequestDto salaRequestDto) {
        Sala sala = new Sala();
        sala.setNome(salaRequestDto.nome());
        sala.setLocalizacao(salaRequestDto.localizacao());
        sala.setCapacidadeMaxima(salaRequestDto.capacidadeMaxima());
        return sala;
    }

    public SalaResponseDto toResponse(Sala sala) {
        return new SalaResponseDto(
                sala.getId(),
                sala.getNome(),
                sala.getLocalizacao(),
                sala.getCapacidadeMaxima(),
                sala.getCriadoEm(),
                sala.getAtualizadoEm()
        );
    }
}
