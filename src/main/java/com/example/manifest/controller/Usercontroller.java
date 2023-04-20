package com.example.manifest.controller;

import com.example.manifest.Entity.Login;
import com.example.manifest.Entity.User;

import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.Userservice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/test/User")

public class Usercontroller {

    @Autowired
    private   Userservice service;


    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> all (@RequestBody User user){return ResponseEntity.ok(service.all());
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
    public void deleteAlluser(@PathVariable Integer id){
        service.deleteUser(id);
    }

    @PostMapping(path="/Login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> Login(@RequestBody Login login) {
        return service.Login(login);
    }



}
