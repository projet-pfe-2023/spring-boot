package com.example.manifest.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Intervenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String adresse;
    private String numerocontribuable;
    private String nom2;
    private Integer telephone;
    private String email;
    private String adresse2;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
