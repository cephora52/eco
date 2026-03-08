package com.example.ecomove.serviceTest;

import com.example.ecomove.dto.ReservationDTO;
import com.example.ecomove.entities.Reservation;
import com.example.ecomove.mappers.ReservationMapper;
import com.example.ecomove.repositories.ReservationRepository;
import com.example.ecomove.services.implementations.ReservationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private ReservationMapper reservationMapper;

    @InjectMocks
    private ReservationService reservationService;

    private Reservation reservation;
    private ReservationDTO reservationDTO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        reservation = new Reservation();
        reservation.setIdReservation(1);

        reservationDTO = new ReservationDTO();
        reservationDTO.setIdReservation(1);
    }

    @Test
    void createReservation() {

        when(reservationMapper.toEntity(reservationDTO)).thenReturn(reservation);
        when(reservationRepository.save(reservation)).thenReturn(reservation);
        when(reservationMapper.toDTO(reservation)).thenReturn(reservationDTO);

        ReservationDTO result = reservationService.createReservation(reservationDTO);

        assertNotNull(result);
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    void getReservationById() {

        when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));
        when(reservationMapper.toDTO(reservation)).thenReturn(reservationDTO);

        ReservationDTO result = reservationService.getReservationById(1);

        assertNotNull(result);
        verify(reservationRepository, times(1)).findById(1);
    }

    @Test
    void getAllReservations() {

        when(reservationRepository.findAll()).thenReturn(List.of(reservation));
        when(reservationMapper.toDTO(reservation)).thenReturn(reservationDTO);

        List<ReservationDTO> result = reservationService.getAllReservations();

        assertEquals(1, result.size());
        verify(reservationRepository, times(1)).findAll();
    }

    @Test
    void updateReservation() {

        when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));
        when(reservationRepository.save(reservation)).thenReturn(reservation);
        when(reservationMapper.toDTO(reservation)).thenReturn(reservationDTO);

        ReservationDTO result = reservationService.updateReservation(1, reservationDTO);

        assertNotNull(result);
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    void deleteReservation() {

        when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));

        doNothing().when(reservationRepository).delete(reservation);

        reservationService.deleteReservation(1);

        verify(reservationRepository, times(1)).delete(reservation);
    }
}