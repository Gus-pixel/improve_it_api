package com.improveit.ImproveIt.domain.setor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "setor")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Setor {
    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private Boolean status;
}
