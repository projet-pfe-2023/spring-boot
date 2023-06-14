package com.example.manifest.service;

import com.example.manifest.Entity.Manifest;
import com.example.manifest.Entity.ManifestStatus;
import com.example.manifest.exception.NotFoundException;
import com.example.manifest.repository.ManifestRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DouaneService {

    private final ManifestRepository manifestRepository;
    public Manifest acceptManifest(Integer manifestId) {
        Manifest manifest = manifestRepository.findById(manifestId)
                .orElseThrow(() -> new NotFoundException("Manifest not found"));
        if(manifest.getStatus() == ManifestStatus.PENDING){
            manifest.setStatus(ManifestStatus.ACCEPTED);
            return manifestRepository.save(manifest);
        }else{
            throw new IllegalStateException("Manifest cannot be accepted");
        }
    }
    public Manifest rejectManifest(Integer manifestId){
        Manifest manifest = manifestRepository.findById(manifestId)
                .orElseThrow(() -> new NotFoundException("Manifest not found"));

        if (manifest.getStatus() == ManifestStatus.PENDING) {
            manifest.setStatus(ManifestStatus.REJECTED);
            return manifestRepository.save(manifest);
        } else {
            throw new IllegalStateException("Manifest cannot be rejected");
        }
    }

}
