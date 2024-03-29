package com.example.manifest.service;
import com.example.manifest.Entity.ERole;
import com.example.manifest.Entity.User;
import com.example.manifest.Token.Token;
import com.example.manifest.Token.TokenRepository;
import com.example.manifest.Token.TokenType;
import com.example.manifest.controller.AuthenticationRequest;
import com.example.manifest.controller.AuthenticationResponse;
import com.example.manifest.controller.RegisterRequest;
import com.example.manifest.exception.UserNotActiveException;
import com.example.manifest.exception.UserNotFoundException;
import com.example.manifest.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user= User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .cin(request.getCin())
                .partenaire(request.getPartenaire())
                .desactive(false)
                .eRole(ERole.USER)
                .build();
        var savedUser = repository.save(user);

        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser,jwtToken);
        return AuthenticationResponse.builder()
                .Token(jwtToken)
                .build();

    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        if (user.isDesactive() == false) {
            throw new UserNotActiveException("not found");
        }

        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .Token(jwtToken)
                .build();

    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);

    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }


    public List<User> getUsers(){
        return (List<User>) repository.findAll();
    }

    public User finduserById(Integer id) {
        Optional<User> utOptional = repository.findById(id);
        if (utOptional.isEmpty()) {
            return null;
        } else {
            return utOptional.get();
        }
    }


}