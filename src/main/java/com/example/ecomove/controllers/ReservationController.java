package com.example.ecomove.controllers;

import com.example.ecomove.dto.ReservationDTO;
import com.example.ecomove.dto.ReservationDTO;
import com.example.ecomove.services.interfaces.ReservationInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationInterface reservationService;

    public ReservationController(ReservationInterface reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ReservationDTO createReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.createReservation(reservationDTO);
    }

    @GetMapping
    public List<ReservationDTO> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ReservationDTO getReservationById(@PathVariable Integer id) {
        return reservationService.getReservationById(id);
    }

    @PutMapping("/{id}")
    public ReservationDTO updateReservation(@PathVariable Integer id,
                                            @RequestBody ReservationDTO reservationDTO) {
        return reservationService.updateReservation(id, reservationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
    }
}
