package com.github.eventmaster_api.repository;

import com.github.eventmaster_api.domain.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, UUID> {
}
