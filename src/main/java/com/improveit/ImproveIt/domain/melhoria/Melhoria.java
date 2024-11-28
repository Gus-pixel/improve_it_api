package com.improveit.ImproveIt.domain.melhoria;

import com.improveit.ImproveIt.domain.pilar.Pilar;
import com.improveit.ImproveIt.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "melhoria")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Melhoria {
    @Id
    @GeneratedValue
    private UUID id;

    private String desc_problema;
    private String desc_melhoria;
    private Date data;
    private Boolean status;
    private Boolean aprovacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_pilar")
    private Pilar pilar;
}
