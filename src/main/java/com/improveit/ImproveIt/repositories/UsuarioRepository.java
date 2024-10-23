package com.improveit.ImproveIt.repositories;

import com.improveit.ImproveIt.domain.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

}
