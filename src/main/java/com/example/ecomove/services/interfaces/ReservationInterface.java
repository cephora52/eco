package com.example.ecomove.services.interfaces;

import com.example.ecomove.dto.ReservationDTO;
import java.util.List;

public interface ReservationInterface {

    ReservationDTO createReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> getAllReservations();

    ReservationDTO getReservationById(Integer id);

    ReservationDTO updateReservation(Integer id, ReservationDTO reservationDTO);

    void deleteReservation(Integer id);
}