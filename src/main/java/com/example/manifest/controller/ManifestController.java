package com.example.manifest.controller;


import com.example.manifest.Entity.Manifest;

import com.example.manifest.Entity.User;
import com.example.manifest.exception.NotFoundException;
import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.Manifestservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Manifest")

public class ManifestController {

    @Autowired
    private Manifestservice service;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(path = "/all")
    public List<Manifest> all () {
           return service.getAllManifest();
    }

    @PostMapping("/manifests")
    public ResponseEntity<Manifest> addManifest(@RequestBody Manifest requestBody) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail  = authentication.getName();
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new NotFoundException("User not Found"));

        Manifest manifest = service.addManifest(requestBody);
        manifest.setUser(user);
        return ResponseEntity.ok(manifest);
    }

}
