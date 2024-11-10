package com.improveit.ImproveIt.repositories;

import com.improveit.ImproveIt.domain.formulario.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestaoRepository extends JpaRepository<Questao, UUID> {}
