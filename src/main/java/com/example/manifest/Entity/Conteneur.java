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
public class Conteneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String scalle;
    private String remp;
    private String marque;
    private String resp;

}
