package com.example.manifest.controller;


import com.example.manifest.Entity.Manifest;

import com.example.manifest.service.Manifestservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Manifest")

public class ManifestController {

    @Autowired
    private Manifestservice service;

    @GetMapping(path = "/all")
    public List<Manifest> all () {
           return service.getAllManifest();
    }

    @PostMapping(path="/addmanifest")
    public Manifest createManifest( @RequestBody Manifest manifest) {
        return service.addManifest(manifest);
    }
}
