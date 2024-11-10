package com.improveit.ImproveIt.repositories;

import com.improveit.ImproveIt.domain.setor.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SetorRepository extends JpaRepository <Setor, UUID> {

}
