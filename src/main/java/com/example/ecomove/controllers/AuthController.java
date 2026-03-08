package com.example.ecomove.controllers;

import com.example.ecomove.jwt.JwtUtils;
import com.example.ecomove.repositories.UtilisateurRepository;
import com.example.ecomove.entities.Utilisateur;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthController(UtilisateurRepository utilisateurRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtils jwtUtils) {

        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        String telephone = request.get("telephone");
        String password = request.get("password");

        Utilisateur user = utilisateurRepository.findByTelephone(telephone);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {

            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtils.generateToken(user.getTelephone());

        return Map.of("token", token);
    }
}