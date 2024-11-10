package com.improveit.ImproveIt.domain.formulario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "questao")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Questao {

    @Id
    @GeneratedValue
    private UUID id;

    private String textoPergunta;

    @ManyToOne
    @JoinColumn(name = "formulario_id")
    private Formulario formulario;

    private Integer nota;

}
