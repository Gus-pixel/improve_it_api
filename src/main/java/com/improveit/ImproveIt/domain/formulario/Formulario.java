package com.improveit.ImproveIt.domain.formulario;

import com.improveit.ImproveIt.domain.setor.Setor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
    private Date dataCriacao;
    private Boolean status = true;

    @ManyToOne
    @JoinColumn(name = "id_setor", nullable = false)
    private Setor setor;

    }
