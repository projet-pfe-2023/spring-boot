package com.example.manifest.service;

import com.example.manifest.Entity.Intervenant;
import com.example.manifest.Entity.Merch;
import com.example.manifest.repository.MerchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Merchservice {

    private final MerchRepository repository;

    @Autowired
    public Merchservice(MerchRepository merchRepository) {
        this.repository = merchRepository;
    }

    public List<Merch> getAllMerch() {
        return repository.findAll();
    }



    public Merch saveMerch(Merch merch) {
        return repository.save(merch);
    }


    public List<Merch> MerchByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }
}