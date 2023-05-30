package com.example.manifest.repository;

import com.example.manifest.Entity.Intervenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervenantRepository extends JpaRepository<Intervenant,Long>{
}
