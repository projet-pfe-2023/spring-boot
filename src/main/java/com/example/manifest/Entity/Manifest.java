package com.example.manifest.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manifest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bureau;
    private String douala;
    private String acconsier;
    private String numvoyage;
    private Date datedepart;
    private Date datearrive;
    private String lieudepart;
    private String destination;
    private String code;
    private String nom;
    private String adresse;
    private String modetransport;
    private String identificationnavire;
    private String paystransporteur;
    private String placetransporteur;
    private Date decharger;
    private String nomconducteur;
    private String nomconducteur2;
    private String nomconducteur3;
    private String rerfimmatriculation;
    private Date dateimmatriculation;
    private Long tonnagebrut;
    private Long nembretitre;
    private Long nembrecolis;
    private Long nembreconteneur;

    @Enumerated(EnumType.STRING)
    private ManifestStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


}
