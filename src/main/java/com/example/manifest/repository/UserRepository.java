package com.example.manifest.repository;

import com.example.manifest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository


public interface UserRepository extends JpaRepository<User,Integer> , CrudRepository<User,Integer> {


    Optional<User> findUserByEmailAndPassword(String email,String password);
    Optional<User> findByEmail(String email);

    Optional<User> findById(Integer userId);

    @Query("SELECT COUNT (u.id) FROM User u")
    Long getTotalUsers();

}
