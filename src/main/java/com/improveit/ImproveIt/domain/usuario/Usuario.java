package com.improveit.ImproveIt.domain.usuario;

import com.improveit.ImproveIt.domain.setor.Setor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "usuario")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private UUID id;

    private String usuario;
    private String senha;
    private String nome;
    private Boolean status;
    private Boolean cargo;

    @ManyToOne
    @JoinColumn(name = "id_setor")
    private Setor setor;
}
