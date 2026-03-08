package com.example.ecomove.mappers;

import com.example.ecomove.dto.UtilisateurDTO;
import com.example.ecomove.entities.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurDTO toDTO(Utilisateur utilisateur);
 @Mapping(target = "password", ignore = true)
    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);
}