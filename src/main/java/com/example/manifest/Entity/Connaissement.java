package com.example.manifest.Entity;

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
    private Long colis;
    private Long nembre;
    private Long poidbrut;
    private Long volume;

}
