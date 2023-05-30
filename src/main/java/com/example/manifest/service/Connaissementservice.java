package com.example.manifest.service;

import com.example.manifest.Entity.Connaissement;

import com.example.manifest.Entity.Conteneur;
import com.example.manifest.repository.ConnaissementRepository;

import com.example.manifest.repository.ConteneurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class Connaissementservice {

    @Autowired
    private ConnaissementRepository repository;

    public List<Connaissement> getAllConnaissement() { return repository.findAll(); }

    public Connaissement addConnaissement(Connaissement connaissement) {
        return repository.save(connaissement);
    }
}
