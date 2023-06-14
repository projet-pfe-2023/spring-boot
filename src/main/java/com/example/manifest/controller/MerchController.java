package com.example.manifest.controller;


import com.example.manifest.Entity.Merch;

import com.example.manifest.Entity.User;
import com.example.manifest.repository.MerchRepository;
import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.Merchservice;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Marchandise")

public class MerchController {

    @Autowired
    private final Merchservice merchservice;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MerchRepository merchRepository;

    public MerchController(Merchservice merchservice) {
        this.merchservice = merchservice;
    }

    @GetMapping(path = "/all")
    public List<Merch> all (){
        return merchservice.getAllMerch();
    }

    @PostMapping("/addmerch")
     public Merch createMerch(Authentication authentication,@RequestBody Merch merch){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        merch.setUser(user);
        return merchservice.saveMerch(merch);
    }

    @GetMapping("/demandesusermerch")
    public List<Merch> getMerchsForUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Integer userId = user.getId();
        return merchservice.MerchByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteMerch(@PathVariable Integer id) {

        merchRepository.deleteById(id);
    }
}
