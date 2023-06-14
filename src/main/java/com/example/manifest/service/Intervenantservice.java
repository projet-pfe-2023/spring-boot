package com.example.manifest.service;

import com.example.manifest.Entity.Connaissement;
import com.example.manifest.Entity.Intervenant;

import com.example.manifest.repository.IntervenantRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class Intervenantservice {

    @Autowired
    private IntervenantRepository repository;

    public List<Intervenant> getAllIntervenant() { return repository.findAll(); }



    public Intervenant saveIntervenant(Intervenant intervenant) {
        return repository.save(intervenant);
    }



    public List<Intervenant> IntervenantByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }


    public void deleteConteneur(Integer id) {

        repository.deleteById(id);
    }
}
