package com.example.manifest.service;

import com.example.manifest.Entity.Conteneur;

import com.example.manifest.repository.ConteneurRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class Conteneurservice {

    @Autowired
    private ConteneurRepository repository;

    public List<Conteneur> getAllConteneur() { return repository.findAll(); }


    public Conteneur saveConteneur(Conteneur conteneur) {
        return repository.save(conteneur);
    }

    public List<Conteneur> ConteneurByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }
    public void deleteConteneur(Integer id) {
        repository.deleteById(id);
    }
}
