package com.example.manifest.controller;

import com.example.manifest.Entity.Manifest;
import com.example.manifest.service.DouaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/Douane")
@RequiredArgsConstructor
public class DaouneController {
    @Autowired
    private final DouaneService douaneService;

    @PutMapping("/manifests/{manifestId}/accept")
    public ResponseEntity<Manifest> acceptManifest(@PathVariable Integer manifestId) {
        Manifest manifest = douaneService.acceptManifest(manifestId);
        return ResponseEntity.ok(manifest);
    }
    @PutMapping("/manifests/{manifestId}/reject")
    public ResponseEntity<Manifest> rejectManifest(@PathVariable Integer manifestId) {
        Manifest manifest = douaneService.rejectManifest(manifestId);
        return ResponseEntity.ok(manifest);
    }
}
