package com.iaugusto.talenthub.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * Representa a vaga disponível na plataforma de gestão de vagas
 *
 * @author Igor A. Santana
 * @since 1.2.1
 */
@Entity(name = "Job")
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    private String benefits;

    private String level;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company id_company;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
