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
public class Connaissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String numero;
    private String nature;
    private String lieuchargement;
    private String lieudechargement;
    private Integer colis;
    private Integer nembre;
    private Integer poidbrut;
    private Integer volume;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
