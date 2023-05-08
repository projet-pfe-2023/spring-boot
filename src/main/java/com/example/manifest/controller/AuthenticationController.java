package com.example.manifest.controller;

import com.example.manifest.Entity.User;
import com.example.manifest.repository.UserRepository;
import com.example.manifest.service.AuthenticationService;
import com.example.manifest.service.LogoutService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.manifest.Entity.ERole;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins ="http://localhost:4200" ,allowCredentials = "true")
@RequestMapping("/api/test/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final LogoutService logoutService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        logoutService.logout(request, response, null);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping(path ="/getuser/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id) {
        User user = service.finduserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }




}
