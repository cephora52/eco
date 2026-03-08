package com.example.ecomove.services.interfaces;

import com.example.ecomove.dto.UtilisateurDTO;
import java.util.List;

public interface UtilisateurInterface {

    UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO);

    List<UtilisateurDTO> getAllUtilisateurs();

    UtilisateurDTO getUtilisateurById(Integer id);

    UtilisateurDTO updateUtilisateur(Integer id, UtilisateurDTO utilisateurDTO);

    void deleteUtilisateur(Integer id);
}