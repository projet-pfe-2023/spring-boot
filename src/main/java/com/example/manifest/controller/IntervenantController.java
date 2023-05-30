package com.example.manifest.controller;


import com.example.manifest.Entity.Intervenant;

import com.example.manifest.repository.IntervenantRepository;

import com.example.manifest.service.Intervenantservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/test/Intervenant")

public class IntervenantController {

    @Autowired
    private Intervenantservice service;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Intervenant>> all (@RequestBody Intervenant intervenant){return ResponseEntity.ok(service.getAllIntervenant());
    }

    @PostMapping(path="/addintervenant")
    public Intervenant createIntervenant( @RequestBody Intervenant intervenant) {
        return service.addIntervenant(intervenant);
    }
}
