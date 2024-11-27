package com.improveit.ImproveIt.domain.ideia;

import com.improveit.ImproveIt.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "ideia")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Ideia {
    @Id
    @GeneratedValue
    private UUID id;

    private String titulo;
    private String desc_ideia;
    private String desc_problema;
    private Date data;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
