package com.example.manifest.controller;

import com.example.manifest.Entity.ERole;
import com.example.manifest.Entity.Login;
import com.example.manifest.Entity.User;
import com.example.manifest.POJO.UserRoleUpdateRequest;
import com.example.manifest.Token.TokenRepository;
import com.example.manifest.exception.ResourceNotFoundException;
import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;

import java.util.Map;

@Controller
@RestController
@CrossOrigin(origins ="http://localhost:4200",allowCredentials = "true")
@RequestMapping("/api/test/User")

public class Usercontroller {

    @Autowired
    private   Userservice service;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;


    @GetMapping("/getall")
    public List<User> getAllusers(){
        return service.getAllUsers();
    }

    @GetMapping(path ="/getuser/{id}")
    public User findUserById(@PathVariable Integer id) {
        return service.finduserById(id);
    }

    @PutMapping(path ="/{user}")
    public User updateAllUser( @RequestBody User user) {
        return service.updateUser(user);
    }

    @PostMapping(path="/adduser")
    public User createUser( @RequestBody User user) {
        return service.addUser(user);
    }

    @DeleteMapping(path="/{id}")
    @Transactional
    public ResponseEntity<Map<String, Boolean>>  deleteuser(@PathVariable Integer id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id: " + id));

        tokenRepository.deleteByUser(user); // Delete associated tokens

        userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path="/Login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> Login(@RequestBody Login login) {
        return service.Login(login);
    }

    @PutMapping("/users/{id}/role")
    public ResponseEntity<User> updateUserRole(@PathVariable Integer id, @RequestBody UserRoleUpdateRequest request) {
        String newRole = request.getNewRole();
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setERole(ERole.valueOf(newRole));
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}/activate")
    public ResponseEntity<String> activateUserAccount(@PathVariable("id") Integer userId) {
        boolean isActivated = service.activateUser(userId);
        if (isActivated) {
            return ResponseEntity.ok("User account activated successfully.");
        }else {
            return ResponseEntity.badRequest().body("Failed to activate user account.");
        }
    }
}
