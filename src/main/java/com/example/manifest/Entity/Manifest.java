package com.example.manifest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Manifest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bureau;
    private String douala;
    private String acconsier;
    private String numvoyage;
    private String heurearrive;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBureau() {
        return bureau;
    }

    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public String getDouala() {
        return douala;
    }

    public void setDouala(String douala) {
        this.douala = douala;
    }

    public String getAcconsier() {
        return acconsier;
    }

    public void setAcconsier(String acconsier) {
        this.acconsier = acconsier;
    }

    public String getNumvoyage() {
        return numvoyage;
    }

    public void setNumvoyage(String numvoyage) {
        this.numvoyage = numvoyage;
    }

    public String getHeurearrive() {
        return heurearrive;
    }

    public void setHeurearrive(String heurearrive) {
        this.heurearrive = heurearrive;
    }

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }

    public Date getDatearrive() {
        return datearrive;
    }

    public void setDatearrive(Date datearrive) {
        this.datearrive = datearrive;
    }

    public String getLieudepart() {
        return lieudepart;
    }

    public void setLieudepart(String lieudepart) {
        this.lieudepart = lieudepart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getModetransport() {
        return modetransport;
    }

    public void setModetransport(String modetransport) {
        this.modetransport = modetransport;
    }

    public String getIdentificationnavire() {
        return identificationnavire;
    }

    public void setIdentificationnavire(String identificationnavire) {
        this.identificationnavire = identificationnavire;
    }

    public String getPaystransporteur() {
        return paystransporteur;
    }

    public void setPaystransporteur(String paystransporteur) {
        this.paystransporteur = paystransporteur;
    }

    public String getPlacetransporteur() {
        return placetransporteur;
    }

    public void setPlacetransporteur(String placetransporteur) {
        this.placetransporteur = placetransporteur;
    }

    public Date getDecharger() {
        return decharger;
    }

    public void setDecharger(Date decharger) {
        this.decharger = decharger;
    }

    public String getNomconducteur() {
        return nomconducteur;
    }

    public void setNomconducteur(String nomconducteur) {
        this.nomconducteur = nomconducteur;
    }

    public String getNomconducteur2() {
        return nomconducteur2;
    }

    public void setNomconducteur2(String nomconducteur2) {
        this.nomconducteur2 = nomconducteur2;
    }

    public String getNomconducteur3() {
        return nomconducteur3;
    }

    public void setNomconducteur3(String nomconducteur3) {
        this.nomconducteur3 = nomconducteur3;
    }

    public String getRerfimmatriculation() {
        return rerfimmatriculation;
    }

    public void setRerfimmatriculation(String rerfimmatriculation) {
        this.rerfimmatriculation = rerfimmatriculation;
    }

    public Date getDateimmatriculation() {
        return dateimmatriculation;
    }

    public void setDateimmatriculation(Date dateimmatriculation) {
        this.dateimmatriculation = dateimmatriculation;
    }

    public Long getTonnagebrut() {
        return tonnagebrut;
    }

    public void setTonnagebrut(Long tonnagebrut) {
        this.tonnagebrut = tonnagebrut;
    }

    public Long getNembretitre() {
        return nembretitre;
    }

    public void setNembretitre(Long nembretitre) {
        this.nembretitre = nembretitre;
    }

    public Long getNembrecolis() {
        return nembrecolis;
    }

    public void setNembrecolis(Long nembrecolis) {
        this.nembrecolis = nembrecolis;
    }

    public Long getNembreconteneur() {
        return nembreconteneur;
    }

    public void setNembreconteneur(Long nembreconteneur) {
        this.nembreconteneur = nembreconteneur;
    }
}
