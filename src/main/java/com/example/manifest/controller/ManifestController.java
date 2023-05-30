package com.example.manifest.controller;


import com.example.manifest.Entity.Manifest;

import com.example.manifest.repository.ManifestRepository;


import com.example.manifest.service.Manifestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/test/Manifest")

public class ManifestController {

    @Autowired
    private Manifestservice service;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Manifest>> all (@RequestBody Manifest manifest){return ResponseEntity.ok(service.getAllManifest());
    }

    @PostMapping(path="/addmanifest")
    public Manifest createManifest( @RequestBody Manifest manifest) {
        return service.addManifest(manifest);
    }
}
