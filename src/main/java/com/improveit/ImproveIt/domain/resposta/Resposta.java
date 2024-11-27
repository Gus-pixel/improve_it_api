package com.improveit.ImproveIt.domain.resposta;

import com.improveit.ImproveIt.domain.formulario.Questao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "resposta")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Resposta {

    @Id
    @GeneratedValue
    private UUID id;

    private int nota; // Nota atribuída à questão

    @ManyToOne
    @JoinColumn(name = "id_questao", nullable = false)
    private Questao questao;
}


