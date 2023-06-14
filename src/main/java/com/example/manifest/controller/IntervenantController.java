package com.example.manifest.controller;


import com.example.manifest.Entity.Connaissement;
import com.example.manifest.Entity.Intervenant;
import com.example.manifest.Entity.User;
import com.example.manifest.repository.IntervenantRepository;
import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.Intervenantservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Intervenant")

public class IntervenantController {

    @Autowired
    private Intervenantservice service;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IntervenantRepository intervenantRepository;

    @GetMapping(path = "/all")
    public List<Intervenant> all (){
        return service.getAllIntervenant();
    }

    @PostMapping(path="/addintervenant")
    public Intervenant createIntervenant(Authentication authentication, @RequestBody Intervenant intervenant) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        intervenant.setUser(user);
        return service.saveIntervenant(intervenant);
    }

    @GetMapping("/demandesuserinter")
    public List<Intervenant> getIntervenantsForUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Integer userId = user.getId();
        return service.IntervenantByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteIntervenant(@PathVariable Integer id) {

        intervenantRepository.deleteById(id);
    }

}
