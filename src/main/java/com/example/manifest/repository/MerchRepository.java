package com.example.manifest.repository;

import com.example.manifest.Entity.Merch;
import com.example.manifest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchRepository extends JpaRepository<Merch, Integer> {

    List<Merch> findByUserId(Integer userId);

    @Modifying
    @Query("DELETE FROM Merch t WHERE t.user = :user")
    void deleteByUser(User user);
}
