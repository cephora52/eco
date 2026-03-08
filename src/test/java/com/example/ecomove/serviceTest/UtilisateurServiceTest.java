package com.example.ecomove.serviceTest;

import com.example.ecomove.dto.UtilisateurDTO;
import com.example.ecomove.entities.Utilisateur;
import com.example.ecomove.mappers.UtilisateurMapper;
import com.example.ecomove.repositories.UtilisateurRepository;
import com.example.ecomove.services.implementations.UtilisateurService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UtilisateurServiceTest {

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @Mock
    private UtilisateurMapper utilisateurMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UtilisateurService utilisateurService;

    private Utilisateur utilisateur;
    private UtilisateurDTO utilisateurDTO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        utilisateur = new Utilisateur();
        utilisateur.setIdUser(1);

        utilisateurDTO = new UtilisateurDTO();
        utilisateurDTO.setIdUser(1);
        utilisateurDTO.setPassword("123456");

        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
    }

    @Test
    void createUtilisateur() {

        when(utilisateurMapper.toEntity(utilisateurDTO)).thenReturn(utilisateur);
        when(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur);
        when(utilisateurMapper.toDTO(utilisateur)).thenReturn(utilisateurDTO);

        UtilisateurDTO result = utilisateurService.createUtilisateur(utilisateurDTO);

        assertNotNull(result);
    }

    @Test
    void getUtilisateurById() {

        when(utilisateurRepository.findById(1)).thenReturn(Optional.of(utilisateur));
        when(utilisateurMapper.toDTO(utilisateur)).thenReturn(utilisateurDTO);

        UtilisateurDTO result = utilisateurService.getUtilisateurById(1);

        assertNotNull(result);
    }

    @Test
    void getAllUtilisateurs() {

        when(utilisateurRepository.findAll()).thenReturn(List.of(utilisateur));
        when(utilisateurMapper.toDTO(utilisateur)).thenReturn(utilisateurDTO);

        List<UtilisateurDTO> result = utilisateurService.getAllUtilisateurs();

        assertEquals(1, result.size());
    }

    @Test
    void updateUtilisateur() {

        when(utilisateurRepository.findById(1)).thenReturn(Optional.of(utilisateur));
        when(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur);
        when(utilisateurMapper.toDTO(utilisateur)).thenReturn(utilisateurDTO);

        UtilisateurDTO result = utilisateurService.updateUtilisateur(1, utilisateurDTO);

        assertNotNull(result);
    }

    @Test
    void deleteUtilisateur() {

        utilisateurService.deleteUtilisateur(1);

        verify(utilisateurRepository).deleteById(1);
    }
}