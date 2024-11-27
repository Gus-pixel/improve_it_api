package com.improveit.ImproveIt.repositories;

import com.improveit.ImproveIt.domain.formulario.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, UUID> {
    // Adicione consultas personalizadas se necessário, como:
    // Optional<Formulario> findByTitulo(String titulo);
}
