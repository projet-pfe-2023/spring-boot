package com.example.manifest.repository;

import com.example.manifest.Entity.Merch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchRepository extends JpaRepository<Merch,Long> {
}
