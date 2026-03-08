package com.example.ecomove.services.implementations;

import com.example.ecomove.dto.ReservationDTO;
import com.example.ecomove.entities.Reservation;
import com.example.ecomove.mappers.ReservationMapper;
import com.example.ecomove.repositories.ReservationRepository;
import com.example.ecomove.services.interfaces.ReservationInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService implements ReservationInterface {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(
            ReservationRepository reservationRepository,
            ReservationMapper reservationMapper) {

        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    // CREATE
    @Override
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {

        Reservation reservation = reservationMapper.toEntity(reservationDTO);

        Reservation saved = reservationRepository.save(reservation);

        return reservationMapper.toDTO(saved);
    }

    // GET ALL
    @Override
    public List<ReservationDTO> getAllReservations() {

        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    @Override
    public ReservationDTO getReservationById(Integer id) {

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        return reservationMapper.toDTO(reservation);
    }

    // UPDATE
    @Override
    public ReservationDTO updateReservation(Integer id, ReservationDTO reservationDTO) {

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setDateReservation(reservationDTO.getDateReservation());
        reservation.setStatusReservation(reservationDTO.getStatusReservation());

        Reservation updated = reservationRepository.save(reservation);

        return reservationMapper.toDTO(updated);
    }

    // DELETE
    @Override
    public void deleteReservation(Integer id) {

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservationRepository.delete(reservation);
    }
}