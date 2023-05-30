package com.example.manifest.controller;

import com.example.manifest.Entity.Merch;

import com.example.manifest.service.Merchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Merch")

public class MerchController {

    @Autowired
    private Merchservice service;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Merch>> all (@RequestBody Merch merch){return ResponseEntity.ok(service.getAllMerch());
    }

    @PostMapping(path="/addmerch")
    @CrossOrigin(origins ="http://localhost:4200")
    public Merch createMerch(@RequestBody Merch merch) {
        return service.addMerch(merch);
    }
}
