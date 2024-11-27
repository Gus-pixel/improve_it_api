package com.improveit.ImproveIt.repositories;

import com.improveit.ImproveIt.domain.formulario.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, UUID> {

}
