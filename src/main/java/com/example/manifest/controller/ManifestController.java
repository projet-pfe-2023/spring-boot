package com.example.manifest.controller;


import com.example.manifest.Entity.Manifest;

import com.example.manifest.Entity.ManifestStatus;
import com.example.manifest.Entity.User;
import com.example.manifest.exception.NotFoundException;
import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.Manifestservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Manifest")

public class ManifestController {

    @Autowired
    private Manifestservice service;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(path = "/all")
    public List<Manifest> all () {
           return service.getAllManifest();
    }

    @PostMapping("/manifests")
    public ResponseEntity<Manifest> addManifest(@RequestBody Manifest requestBody) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail  = authentication.getName();
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new NotFoundException("User not Found"));

        Manifest manifest = service.addManifest(requestBody);
        manifest.setUser(user);
        return ResponseEntity.ok(manifest);
    }

    @PutMapping("/manifests/{manifestId}")
    public ResponseEntity<Manifest> updateManifest(@PathVariable("manifestId") Integer manifestId, @RequestBody Manifest requestBody) {
        Manifest existingManifest = service.getManifestById(manifestId)
                .orElseThrow(() -> new NotFoundException("Manifest not found"));

        existingManifest.setStatus(ManifestStatus.PENDING);
        existingManifest.setBureau(requestBody.getBureau());
        existingManifest.setDouala(requestBody.getDouala());
        existingManifest.setAcconsier(requestBody.getAcconsier());
        existingManifest.setNumvoyage(requestBody.getNumvoyage());
        existingManifest.setDatedepart(requestBody.getDatedepart());
        existingManifest.setDatearrive(requestBody.getDatearrive());
        existingManifest.setLieudepart(requestBody.getLieudepart());
        existingManifest.setDestination(requestBody.getDestination());
        existingManifest.setCode(requestBody.getCode());
        existingManifest.setNom(requestBody.getNom());
        existingManifest.setAdresse(requestBody.getAdresse());
        existingManifest.setModetransport(requestBody.getModetransport());
        existingManifest.setIdentificationnavire(requestBody.getIdentificationnavire());
        existingManifest.setPaystransporteur(requestBody.getPaystransporteur());
        existingManifest.setPlacetransporteur(requestBody.getPlacetransporteur());
        existingManifest.setDecharger(requestBody.getDecharger());
        existingManifest.setNomconducteur(requestBody.getNomconducteur());
        existingManifest.setNomconducteur2(requestBody.getNomconducteur2());
        existingManifest.setNomconducteur3(requestBody.getNomconducteur3());
        existingManifest.setRerfimmatriculation(requestBody.getRerfimmatriculation());
        existingManifest.setDateimmatriculation(requestBody.getDateimmatriculation());
        existingManifest.setTonnagebrut(requestBody.getTonnagebrut());
        existingManifest.setNembretitre(requestBody.getNembretitre());
        existingManifest.setNembrecolis(requestBody.getNembrecolis());
        existingManifest.setNembreconteneur(requestBody.getNembreconteneur());

        Manifest updatedManifest = service.updateManifest(existingManifest);
        return ResponseEntity.ok(updatedManifest);
    }


}
