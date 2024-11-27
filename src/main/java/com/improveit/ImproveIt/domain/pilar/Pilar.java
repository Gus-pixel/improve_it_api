package com.improveit.ImproveIt.domain.pilar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "pilar")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pilar {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private Boolean status;

}
