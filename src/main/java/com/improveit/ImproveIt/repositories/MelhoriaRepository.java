package com.improveit.ImproveIt.repositories;

import com.improveit.ImproveIt.domain.melhoria.Melhoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MelhoriaRepository extends JpaRepository<Melhoria, UUID> {
}
