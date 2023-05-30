package com.example.manifest.controller;

import com.example.manifest.Entity.Conteneur;

import com.example.manifest.repository.ConteneurRepository;
import com.example.manifest.service.Conteneurservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/test/Conteneur")

public class ConteneurController {

    @Autowired
    private Conteneurservice service;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Conteneur>> all (@RequestBody Conteneur conteneur){return ResponseEntity.ok(service.getAllConteneur());
    }

    @PostMapping(path="/addconteneur")
    public Conteneur createConteneur( @RequestBody Conteneur conteneur) {
        return service.addConteneur(conteneur);
    }
}
