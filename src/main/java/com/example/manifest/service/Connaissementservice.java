package com.example.manifest.service;

import com.example.manifest.Entity.Connaissement;


import com.example.manifest.repository.ConnaissementRepository;


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



    public Connaissement saveConnaissement(Connaissement connaissement) {
        return repository.save(connaissement);
    }

    public List<Connaissement> ConnaissementByUserId(Integer userId) {
        return repository.findByUserId(userId);

    }
    public void deleteConnaissement(Integer id) {
        repository.deleteById(id);
    }


}
