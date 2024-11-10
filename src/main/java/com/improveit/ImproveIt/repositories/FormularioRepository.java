package com.improveit.ImproveIt.repositories;

import com.improveit.ImproveIt.domain.formulario.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormularioRepository extends JpaRepository<Formulario, UUID> {}
