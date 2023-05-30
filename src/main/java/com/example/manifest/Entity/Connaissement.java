package com.example.manifest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Connaissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String numero;
    private String nature;
    private String lieuchargement;
    private String lieudechargement;
    private Long colis;
    private Long nembre;
    private Long poidbrut;
    private Long volume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getLieuchargement() {
        return lieuchargement;
    }

    public void setLieuchargement(String lieuchargement) {
        this.lieuchargement = lieuchargement;
    }

    public String getLieudechargement() {
        return lieudechargement;
    }

    public void setLieudechargement(String lieudechargement) {
        this.lieudechargement = lieudechargement;
    }

    public Long getColis() {
        return colis;
    }

    public void setColis(Long colis) {
        this.colis = colis;
    }

    public Long getNembre() {
        return nembre;
    }

    public void setNembre(Long nembre) {
        this.nembre = nembre;
    }

    public Long getPoidbrut() {
        return poidbrut;
    }

    public void setPoidbrut(Long poidbrut) {
        this.poidbrut = poidbrut;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }
}
