package com.example.manifest.controller;

import com.example.manifest.Entity.Connaissement;

import com.example.manifest.service.Connaissementservice;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Connaissement")


public class ConnaissementController {

    @Autowired
    private Connaissementservice service;

    @GetMapping(path = "/all")
    public List<Connaissement> all (){
        return service.getAllConnaissement();
    }

    @PostMapping(path="/addconnaissement")
    public Connaissement createConnaissement( @RequestBody Connaissement connaissement) {
        return service.addConnaissement(connaissement);
    }
}
