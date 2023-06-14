package com.example.manifest.repository;

import com.example.manifest.Entity.Conteneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConteneurRepository extends JpaRepository<Conteneur,Integer>{
    List<Conteneur> findByUserId(Integer userId);
}
