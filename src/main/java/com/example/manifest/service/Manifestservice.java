package com.example.manifest.service;

import com.example.manifest.Entity.Manifest;

import com.example.manifest.Entity.ManifestStatus;
import com.example.manifest.repository.ManifestRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor

public class Manifestservice {

    @Autowired
    private ManifestRepository repository;

    public List<Manifest> getAllManifest() { return repository.findAll(); }


    public Manifest addManifest(Manifest requestBody) {
        Manifest manifest = new Manifest();
        manifest.setStatus(ManifestStatus.PENDING);
        manifest.setBureau(requestBody.getBureau());
        manifest.setDouala(requestBody.getDouala());
        manifest.setAcconsier(requestBody.getAcconsier());
        manifest.setNumvoyage(requestBody.getNumvoyage());
        manifest.setDatedepart(requestBody.getDatedepart());
        manifest.setDatearrive(requestBody.getDatearrive());
        manifest.setLieudepart(requestBody.getLieudepart());
        manifest.setDestination(requestBody.getDestination());
        manifest.setCode(requestBody.getCode());
        manifest.setNom(requestBody.getNom());
        manifest.setAdresse(requestBody.getAdresse());
        manifest.setModetransport(requestBody.getModetransport());
        manifest.setIdentificationnavire(requestBody.getIdentificationnavire());
        manifest.setPaystransporteur(requestBody.getPaystransporteur());
        manifest.setPlacetransporteur(requestBody.getPlacetransporteur());
        manifest.setDecharger(requestBody.getDecharger());
        manifest.setNomconducteur(requestBody.getNomconducteur());
        manifest.setNomconducteur2(requestBody.getNomconducteur2());
        manifest.setNomconducteur3(requestBody.getNomconducteur3());
        manifest.setRerfimmatriculation(requestBody.getRerfimmatriculation());
        manifest.setDateimmatriculation(requestBody.getDateimmatriculation());
        manifest.setTonnagebrut(requestBody.getTonnagebrut());
        manifest.setNembretitre(requestBody.getNembretitre());
        manifest.setNembrecolis(requestBody.getNembrecolis());
        manifest.setNembreconteneur(requestBody.getNembreconteneur());

        return repository.save(manifest);
    }
}
