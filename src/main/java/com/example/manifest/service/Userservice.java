package com.example.manifest.service;

import com.example.manifest.Entity.ERole;
import com.example.manifest.Entity.Login;
import com.example.manifest.Entity.User;

import com.example.manifest.exception.UserNotFoundException;
import com.example.manifest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class Userservice {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() { return repository.findAll(); }

    public User finduserById(Integer id) {
        Optional<User> utOptional = repository.findById(id);
        if (utOptional.isEmpty()) {
            return null;
        } else {
            return utOptional.get();
        }
    }

    public User addUser(User user) {
        return repository.save(user);
    }


    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }


    public User updateUser(User user) {
        Optional<User> utOptional = repository.findById(user.getId());
        if (utOptional.isEmpty()) {
            return null;
        } else {
            return repository.save(user);
        }
    }

    public Integer save(User user) {
        return repository.save(user).getId();
    }
    public List<User>all(){
        return repository.findAll();
    }

    public ResponseEntity<?>Login(Login login){
        User user = repository.findUserByEmailAndPassword(login.getEmail(),login.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
    }

    public User updateUserRole(Integer id, String newRole) {
        User user = repository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User with ID " + id + " not found.");
        }
        user.setERole(ERole.valueOf(newRole));
        return repository.save(user);
    }

    public boolean activateUser(Integer userId) {
        User user = repository.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
        user.setEnabled(true);
        repository.save(user);
        return true;
    }
}
