package com.example.manifest.controller;


import com.example.manifest.Entity.Manifest;
import com.example.manifest.Entity.ManifestStatus;
import com.example.manifest.Entity.User;
import com.example.manifest.exception.NotFoundException;
import com.example.manifest.repository.ManifestRepository;
import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.Manifestservice;
import com.example.manifest.service.Userservice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;



import java.util.List;



@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Manifest")

public class ManifestController {

    private final Manifestservice service;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final ManifestRepository manifestrepository;
    private final Userservice userservice;

    @Autowired
    public ManifestController(Manifestservice service, UserRepository userRepository,
                              AuthenticationManager authenticationManager,ManifestRepository manifestrepository, Userservice userservice) {
        this.service = service;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.manifestrepository = manifestrepository;
        this.userservice = userservice;
    }


    @GetMapping(path = "/all")
    public List<Manifest> all () {
           return service.getAllManifest();
    }


    @PostMapping("/addmanifests")
    public Manifest addManifest(Authentication authentication, @RequestBody Manifest manifest) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        manifest.setUser(user);
        manifest.setStatus(ManifestStatus.DEFAULT);
        return service.saveManifest(manifest);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Manifest> updateManifest(Authentication authentication, @PathVariable Integer id, @RequestBody Manifest updatedManifest) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Manifest existingManifest = service.getManifestById(id)
                .orElseThrow(() -> new NotFoundException("Manifest not found"));

        if (existingManifest.getStatus() != ManifestStatus.ACCEPTED) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        BeanUtils.copyProperties(updatedManifest, existingManifest, "id", "user");

        existingManifest.setStatus(ManifestStatus.ACCEPTED);
        existingManifest.setUser(user);

        Manifest savedManifest = service.saveManifest(existingManifest);
        return new ResponseEntity<>(savedManifest, HttpStatus.OK);
    }



    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @PutMapping("/demande/{manifestId}/Modifier")
    public ResponseEntity<Manifest> demandeModification(@PathVariable Integer manifestId) {
        Manifest manifest = service.demandeModification(manifestId);
        return ResponseEntity.ok(manifest);
    }

    @GetMapping(path = "/total")
    public Long getTotalManifest() {
        return service.getTotalManifest();
    }
    @GetMapping("/totalupdate")
    public  Long getTotalManifestsWithAcceptedStatus(){
        return service.getTotalManifestsWithAcceptedStatus();
    }

    @GetMapping(path = "/totalmanifest")
    public Long getTotalManifestByStatus() {
        return service.getTotalManifestByStatus();
    }

    @GetMapping("/demandesuser")
    public List<Manifest> getManifestsForUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Integer userId = user.getId();
        return service.getManifestsByUserId(userId);
    }


}
