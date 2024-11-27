package com.improveit.ImproveIt.domain.formulario;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "questao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "formulario")
public class Questao {

    @Id
    @UuidGenerator
    @Column(updatable = false, nullable = false, unique = true)
    private UUID id;

    @NotBlank(message = "O texto da pergunta não pode estar vazio.")
    @Size(max = 255, message = "O texto da pergunta não pode exceder 255 caracteres.")
    @Column(nullable = false)
    private String texto_pergunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formulario", nullable = false)
    private Formulario formulario;

    @NotNull(message = "A nota não pode ser nula.")
    @Min(value = 1, message = "A nota mínima é 1.")
    @Max(value = 5, message = "A nota máxima é 5.")
    private Integer nota;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questao questao = (Questao) o;
        return Objects.equals(id, questao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
