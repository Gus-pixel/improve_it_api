package com.improveit.ImproveIt.repositories;

import com.improveit.ImproveIt.domain.resposta.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RespostaRepository extends JpaRepository<Resposta, UUID>{
}
