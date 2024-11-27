package com.improveit.ImproveIt.domain.usuario;

public record UsuarioRequestDTO(String usuario, String senha, String nome, Boolean status, Boolean cargo) {
}
