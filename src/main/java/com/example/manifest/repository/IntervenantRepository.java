package com.example.manifest.repository;

import com.example.manifest.Entity.Connaissement;
import com.example.manifest.Entity.Intervenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntervenantRepository extends JpaRepository<Intervenant,Integer>{
    List<Intervenant> findByUserId(Integer userId);
}
