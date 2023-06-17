package com.example.manifest.repository;

import com.example.manifest.Entity.Connaissement;
import com.example.manifest.Entity.Intervenant;
import com.example.manifest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntervenantRepository extends JpaRepository<Intervenant,Integer>{
    List<Intervenant> findByUserId(Integer userId);

    @Modifying
    @Query("DELETE FROM Intervenant t WHERE t.user = :user")
    void deleteByUser(User user);
}
