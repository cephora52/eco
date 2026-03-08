package com.example.ecomove.mappers;

import com.example.ecomove.dto.TrajetDTO;
import com.example.ecomove.entities.Trajet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrajetMapper {

    TrajetDTO toDTO(Trajet trajet);

    Trajet toEntity(TrajetDTO trajetDTO);
}