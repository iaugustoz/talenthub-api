package com.iaugusto.talenthub.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * Representa o candidato na plataforma de gestão de vagas
 *
 * @author Igor A. Santana
 * @since 1.1.1
 */
@Entity(name = "Candidate")
@Table(name = "candidate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Pattern(
            regexp = "\\S+",
            message = "Username inválido. O formato é fulanodasilva"
    )
    private String username;

    @Email(message = "E-mail inválido. O formato é email@host.com.br")
    private String email;

    @Length(min = 10,
            max = 100,
            message = "A senha deve conter entre 10 e 100 caracteres"
    )
    private String password;

    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
