package com.example.manifest.controller;

import com.example.manifest.Entity.Merch;

import com.example.manifest.service.Merchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Marchandise")

public class MerchController {

    @Autowired
    private final Merchservice merchservice;

    public MerchController(Merchservice merchservice) {
        this.merchservice = merchservice;
    }

    @GetMapping(path = "/all")
    public List<Merch> all (){
        return merchservice.getAllMerch();
    }

    @PostMapping("/addmerch")
     public Merch createMerch(@RequestBody Merch merch){
        return merchservice.addMerch(merch);
    }
}
