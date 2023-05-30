package com.example.manifest.controller;


import com.example.manifest.Entity.Intervenant;
import com.example.manifest.service.Intervenantservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Intervenant")

public class IntervenantController {

    @Autowired
    private Intervenantservice service;

    @GetMapping(path = "/all")
    public List<Intervenant> all (){
        return service.getAllIntervenant();
    }

    @PostMapping(path="/addintervenant")
    public Intervenant createIntervenant( @RequestBody Intervenant intervenant) {
        return service.addIntervenant(intervenant);
    }
}
