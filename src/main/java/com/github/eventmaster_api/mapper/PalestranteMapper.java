package com.github.eventmaster_api.mapper;

import com.github.eventmaster_api.domain.Palestrante;
import com.github.eventmaster_api.dto.request.PalestranteRequestDto;
import com.github.eventmaster_api.dto.response.PalestranteResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PalestranteMapper {

    public Palestrante toEntity(PalestranteRequestDto palestranteRequestDto) {
        Palestrante palestrante = new Palestrante();
        palestrante.setNome(palestranteRequestDto.nome());
        palestrante.setEmail(palestranteRequestDto.email());
        palestrante.setEspecialidade(palestranteRequestDto.especialidade());
        palestrante.setMiniBiografia(palestranteRequestDto.miniBiografia());
        return palestrante;
    }

    public PalestranteResponseDto toResponse(Palestrante palestrante) {
        return new PalestranteResponseDto(
                palestrante.getId(),
                palestrante.getNome(),
                palestrante.getEmail(),
                palestrante.getEspecialidade(),
                palestrante.getMiniBiografia(),
                palestrante.getCriadoEm(),
                palestrante.getAtualizadoEm()
        );
    }
}
