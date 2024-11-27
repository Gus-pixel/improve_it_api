package com.improveit.ImproveIt.domain.usuario;

import java.util.UUID;

public record UsuarioRequestDTO(String usuario, String senha, String nome, Boolean status, Boolean cargo, UUID id_setor) {
}
