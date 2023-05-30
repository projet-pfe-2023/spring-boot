package com.example.manifest.repository;

import com.example.manifest.Entity.Manifest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManifestRepository extends JpaRepository<Manifest,Integer>{
}
