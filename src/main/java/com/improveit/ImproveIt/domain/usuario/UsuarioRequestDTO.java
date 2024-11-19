package com.improveit.ImproveIt.domain.usuario;

public record UsuarioRequestDTO(String username, String senha, String nome, Boolean status, Boolean cargo) {
}
