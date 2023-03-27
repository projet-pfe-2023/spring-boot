package com.example.manifest.controller;

import com.example.manifest.Entity.Role;
import com.example.manifest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test/Role")
public class RoleControleur {
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Role>> allRols(){
        return ResponseEntity.ok(roleRepository.findAll());
    }
}
