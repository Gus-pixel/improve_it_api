package com.improveit.ImproveIt.domain.formulario;

import com.improveit.ImproveIt.domain.setor.Setor;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "formulario")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Formulario {

    @Id
    @GeneratedValue
    private UUID id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_setor")
    private Setor setor;

    private LocalDateTime dataCriacao;

    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formulario")
    private List<com.improveit.ImproveIt.domain.formulario.Questao> questoes;
}
