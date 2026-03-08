package com.example.ecomove.services.implementations;

import com.example.ecomove.dto.UtilisateurDTO;
import com.example.ecomove.entities.Utilisateur;
import com.example.ecomove.mappers.UtilisateurMapper;
import com.example.ecomove.repositories.UtilisateurRepository;
import com.example.ecomove.services.interfaces.UtilisateurInterface;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService implements UtilisateurInterface {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurService(UtilisateurRepository utilisateurRepository,
                              UtilisateurMapper utilisateurMapper,
                              PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO) {

        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDTO);

        // encoder le mot de passe envoyé
        utilisateur.setPassword(passwordEncoder.encode(utilisateurDTO.getPassword()));

        Utilisateur saved = utilisateurRepository.save(utilisateur);

        return utilisateurMapper.toDTO(saved);
    }

    @Override
    public List<UtilisateurDTO> getAllUtilisateurs() {

        return utilisateurRepository.findAll()
                .stream()
                .map(utilisateurMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDTO getUtilisateurById(Integer id) {

        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        return utilisateurMapper.toDTO(utilisateur);
    }

    @Override
    public UtilisateurDTO updateUtilisateur(Integer id, UtilisateurDTO utilisateurDTO) {

        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));

        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setTelephone(utilisateurDTO.getTelephone());
        utilisateur.setRole(utilisateurDTO.getRole());

        // si un nouveau password est fourni
        if (utilisateurDTO.getPassword() != null) {
            utilisateur.setPassword(passwordEncoder.encode(utilisateurDTO.getPassword()));
        }

        Utilisateur updated = utilisateurRepository.save(utilisateur);

        return utilisateurMapper.toDTO(updated);
    }

    @Override
    public void deleteUtilisateur(Integer id) {

        utilisateurRepository.deleteById(id);
    }
}