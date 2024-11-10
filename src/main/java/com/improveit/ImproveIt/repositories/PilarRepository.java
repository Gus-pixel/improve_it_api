package com.improveit.ImproveIt.repositories;

import com.improveit.ImproveIt.domain.user.Pilar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PilarRepository extends JpaRepository< Pilar, UUID> {
}
