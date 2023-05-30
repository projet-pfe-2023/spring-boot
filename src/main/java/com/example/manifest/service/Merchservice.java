package com.example.manifest.service;

import com.example.manifest.Entity.Merch;

import com.example.manifest.repository.MerchRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class Merchservice {

    @Autowired
    private MerchRepository repository;

    public List<Merch> getAllMerch() { return repository.findAll(); }

    public Merch addMerch(Merch merch) {
        return repository.save(merch);
    }
}
