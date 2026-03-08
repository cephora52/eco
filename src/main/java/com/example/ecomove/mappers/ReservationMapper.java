package com.example.ecomove.mappers;

import com.example.ecomove.dto.ReservationDTO;
import com.example.ecomove.entities.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "idUser.idUser", target = "idUser")
    @Mapping(source = "idTrajet.idTrajet", target = "idTrajet")
    ReservationDTO toDTO(Reservation reservation);

    @Mapping(source = "idUser", target = "idUser.idUser")
    @Mapping(source = "idTrajet", target = "idTrajet.idTrajet")
    Reservation toEntity(ReservationDTO reservationDTO);
}
