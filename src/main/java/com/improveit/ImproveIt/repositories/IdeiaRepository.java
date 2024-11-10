package com.improveit.ImproveIt.repositories;

import com.improveit.ImproveIt.domain.user.Ideia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IdeiaRepository extends JpaRepository<Ideia, UUID> {
}