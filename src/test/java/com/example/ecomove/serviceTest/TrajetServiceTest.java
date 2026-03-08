package com.example.ecomove.serviceTest;

import com.example.ecomove.dto.TrajetDTO;
import com.example.ecomove.entities.Trajet;
import com.example.ecomove.mappers.TrajetMapper;
import com.example.ecomove.repositories.TrajetRepository;
import com.example.ecomove.services.implementations.TrajetService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrajetServiceTest {

    @Mock
    private TrajetRepository trajetRepository;

    @Mock
    private TrajetMapper trajetMapper;

    @InjectMocks
    private TrajetService trajetService;

    private Trajet trajet;
    private TrajetDTO trajetDTO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        trajet = new Trajet();
        trajet.setIdTrajet(1);

        trajetDTO = new TrajetDTO();
        trajetDTO.setIdTrajet(1);
    }

    @Test
    void createTrajet() {

        when(trajetMapper.toEntity(trajetDTO)).thenReturn(trajet);
        when(trajetRepository.save(trajet)).thenReturn(trajet);
        when(trajetMapper.toDTO(trajet)).thenReturn(trajetDTO);

        TrajetDTO result = trajetService.createTrajet(trajetDTO);

        assertNotNull(result);
    }

    @Test
    void getTrajetById() {

        when(trajetRepository.findById(1)).thenReturn(Optional.of(trajet));
        when(trajetMapper.toDTO(trajet)).thenReturn(trajetDTO);

        TrajetDTO result = trajetService.getTrajetById(1);

        assertNotNull(result);
    }

    @Test
    void getAllTrajets() {

        when(trajetRepository.findAll()).thenReturn(List.of(trajet));
        when(trajetMapper.toDTO(trajet)).thenReturn(trajetDTO);

        List<TrajetDTO> result = trajetService.getAllTrajets();

        assertEquals(1, result.size());
    }

    @Test
    void updateTrajet() {

        when(trajetRepository.findById(1)).thenReturn(Optional.of(trajet));
        when(trajetRepository.save(trajet)).thenReturn(trajet);
        when(trajetMapper.toDTO(trajet)).thenReturn(trajetDTO);

        TrajetDTO result = trajetService.updateTrajet(1, trajetDTO);

        assertNotNull(result);
    }

    @Test
    void deleteTrajet() {

        trajetService.deleteTrajet(1);

        verify(trajetRepository).deleteById(1);
    }
}
