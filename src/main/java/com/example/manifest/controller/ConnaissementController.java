package com.example.manifest.controller;

import com.example.manifest.Entity.Connaissement;


import com.example.manifest.Entity.Manifest;
import com.example.manifest.Entity.User;
import com.example.manifest.repository.ConnaissementRepository;
import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.Connaissementservice;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Connaissement")


public class ConnaissementController {

    @Autowired
    private Connaissementservice service;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConnaissementRepository connaissementRepository;

    @GetMapping(path = "/all")
    public List<Connaissement> all() {
        return service.getAllConnaissement();
    }

    @PostMapping(path = "/addconnaissement")
    public Connaissement createConnaissement(Authentication authentication,
                                             @RequestBody Connaissement connaissement) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        connaissement.setUser(user);

        return service.saveConnaissement(connaissement);


    }
    @GetMapping("/demandesuserconnais")
    public List<Connaissement> getConnaissementsForUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Integer userId = user.getId();
        return service.ConnaissementByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteConnaissement(@PathVariable Integer id) {
        connaissementRepository.deleteById(id);
    }


}