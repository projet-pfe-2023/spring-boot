package com.example.manifest.repository;

import com.example.manifest.Entity.Merch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchRepository extends JpaRepository<Merch, Integer> {

    List<Merch> findByUserId(Integer userId);
}
