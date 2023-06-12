package com.example.manifest.repository;

import com.example.manifest.Entity.Manifest;
import com.example.manifest.Entity.ManifestStatus;
import com.example.manifest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManifestRepository extends JpaRepository<Manifest,Integer> {
    List<Manifest> findAllByUserId(Integer userId);
    Optional<Manifest> findById( Integer id);
    List<Manifest> findByUserId(Integer userId);

    @Query("SELECT COUNT (m.id) FROM Manifest m")
    Long getTotalManifest();

    @Query("SELECT COUNT (m.id) FROM Manifest m WHERE m.status = :status")
    Long getTotalManifestByStatus(@Param("status") ManifestStatus status);

}
