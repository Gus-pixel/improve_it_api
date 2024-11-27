package com.improveit.ImproveIt.domain.formulario;

import com.improveit.ImproveIt.domain.setor.Setor;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_setor", nullable = false)
    private Setor setor;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    private Boolean status = true;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formulario", orphanRemoval = true)
    private List<Questao> questoes;
}
