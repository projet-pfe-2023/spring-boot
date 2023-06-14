package com.example.manifest.controller;

import com.example.manifest.Entity.Conteneur;

import com.example.manifest.Entity.Merch;
import com.example.manifest.Entity.User;
import com.example.manifest.repository.ConteneurRepository;
import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.Conteneurservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Conteneur")

public class ConteneurController {

    @Autowired
    private Conteneurservice service;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConteneurRepository conteneurRepository;

    @GetMapping(path = "/all")
    public List<Conteneur> all (){
        return service.getAllConteneur();
    }

    @PostMapping(path="/addconteneur")
    public Conteneur createConteneur(Authentication authentication,@RequestBody Conteneur conteneur) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        conteneur.setUser(user);
        return service.saveConteneur(conteneur);
    }

    @GetMapping("/demandesuserconteneur")
    public List<Conteneur> getConteneursForUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Integer userId = user.getId();
        return service.ConteneurByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteConteneur(@PathVariable Integer id) {

        conteneurRepository.deleteById(id);
    }

}
