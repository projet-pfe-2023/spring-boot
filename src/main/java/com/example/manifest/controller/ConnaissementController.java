package com.example.manifest.controller;

import com.example.manifest.Entity.Connaissement;

import com.example.manifest.Entity.Conteneur;
import com.example.manifest.repository.ConnaissementRepository;
import com.example.manifest.service.Connaissementservice;

import com.example.manifest.service.Conteneurservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/test/Connaissement")


public class ConnaissementController {

    @Autowired
    private Connaissementservice service;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Connaissement>> all (@RequestBody Connaissement connaissement){return ResponseEntity.ok(service.getAllConnaissement());
    }

    @PostMapping(path="/addconnaissement")
    public Connaissement createConnaissement( @RequestBody Connaissement connaissement) {
        return service.addConnaissement(connaissement);
    }
}
