package com.example.manifest.repository;

import com.example.manifest.Entity.Connaissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnaissementRepository extends JpaRepository<Connaissement,Integer>{

}
