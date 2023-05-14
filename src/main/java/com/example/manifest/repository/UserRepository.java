package com.example.manifest.repository;

import com.example.manifest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findUserByEmailAndPassword(String email,String password);
    Optional<User> findByEmail(String email);

}
