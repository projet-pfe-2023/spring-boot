package com.example.manifest.service;

import com.example.manifest.Entity.Manifest;

import com.example.manifest.Entity.ManifestStatus;
import com.example.manifest.Entity.User;
import com.example.manifest.exception.NotFoundException;
import com.example.manifest.repository.ManifestRepository;

import com.example.manifest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class Manifestservice {

    @Autowired
    private ManifestRepository manifestRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Manifest> getAllManifest() {
        return manifestRepository.findAll();
    }

    public Optional<Manifest>  getManifestById(Integer id) {
        return manifestRepository.findById(id);
    }



    public Manifest saveManifest(Manifest manifest) {
        return manifestRepository.save(manifest);
    }




    public Manifest demandeModification(Integer manifestId) {
        Manifest manifest = manifestRepository.findById(manifestId)
                .orElseThrow(() -> new NotFoundException("Manifest not found"));
        if (manifest.getStatus() == ManifestStatus.DEFAULT) {
            manifest.setStatus(ManifestStatus.PENDING);
            return manifestRepository.save(manifest);
        } else {
            throw new IllegalStateException("Manifest cannot be pending");
        }
    }

    public Long getTotalManifest() {

        return manifestRepository.getTotalManifest();
    }

    public Long getTotalManifestByStatus() {
        return manifestRepository.getTotalManifestByStatus(ManifestStatus.ACCEPTED);
    }


    public List<Manifest> getManifestsByUserId(Integer userId) {
        return manifestRepository.findByUserId(userId);
    }

}