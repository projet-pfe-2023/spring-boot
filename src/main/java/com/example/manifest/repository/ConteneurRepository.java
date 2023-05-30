package com.example.manifest.repository;

import com.example.manifest.Entity.Conteneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteneurRepository extends JpaRepository<Conteneur,Integer>{
}
