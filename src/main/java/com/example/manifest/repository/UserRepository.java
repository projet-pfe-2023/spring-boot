package com.example.manifest.repository;

import com.example.manifest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findUserByEmailAndPassword(String email,String password);

}
