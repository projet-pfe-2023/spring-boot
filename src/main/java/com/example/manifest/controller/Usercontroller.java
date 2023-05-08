package com.example.manifest.controller;

import com.example.manifest.Entity.ERole;
import com.example.manifest.Entity.Login;
import com.example.manifest.Entity.User;
import com.example.manifest.POJO.UserRoleUpdateRequest;
import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.Userservice;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    public void deleteAlluser(@PathVariable Integer id){
        service.deleteUser(id);
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


}
