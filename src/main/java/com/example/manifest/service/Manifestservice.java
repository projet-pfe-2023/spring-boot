package com.example.manifest.service;

import com.example.manifest.Entity.Intervenant;
import com.example.manifest.Entity.Manifest;

import com.example.manifest.repository.IntervenantRepository;
import com.example.manifest.repository.ManifestRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class Manifestservice {

    @Autowired
    private ManifestRepository repository;

    public List<Manifest> getAllManifest() { return repository.findAll(); }

    public Manifest addManifest(Manifest manifest) {
        return repository.save(manifest);
    }
}
