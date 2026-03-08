package com.example.ecomove.controllers;

import com.example.ecomove.dto.UtilisateurDTO;
import com.example.ecomove.services.interfaces.UtilisateurInterface;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "*")
public class UtilisateurController {

    private final UtilisateurInterface utilisateurService;

    public UtilisateurController(UtilisateurInterface utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    // Créer un utilisateur
    @PostMapping
    public UtilisateurDTO createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.createUtilisateur(utilisateurDTO);
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public UtilisateurDTO getUtilisateurById(@PathVariable Integer id) {
        return utilisateurService.getUtilisateurById(id);
    }

    // Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public UtilisateurDTO updateUtilisateur(@PathVariable Integer id,
                                            @RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.updateUtilisateur(id, utilisateurDTO);
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.deleteUtilisateur(id);
    }
}