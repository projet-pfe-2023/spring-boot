package com.example.manifest.repository;

import com.example.manifest.Entity.Connaissement;

import com.example.manifest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConnaissementRepository extends JpaRepository<Connaissement,Integer>{
    List<Connaissement> findByUserId(Integer userId);

    @Modifying
    @Query("DELETE FROM Connaissement t WHERE t.user = :user")
    void deleteByUser(User user);

}
