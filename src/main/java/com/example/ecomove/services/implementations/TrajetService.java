package com.example.ecomove.services.implementations;

import com.example.ecomove.dto.TrajetDTO;
import com.example.ecomove.entities.Trajet;
import com.example.ecomove.mappers.TrajetMapper;
import com.example.ecomove.repositories.TrajetRepository;
import com.example.ecomove.services.interfaces.TrajetInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrajetService implements TrajetInterface {

    private final TrajetRepository trajetRepository;
    private final TrajetMapper trajetMapper;

    public TrajetService(TrajetRepository trajetRepository,
                         TrajetMapper trajetMapper) {
        this.trajetRepository = trajetRepository;
        this.trajetMapper = trajetMapper;
    }

    @Override
    public TrajetDTO createTrajet(TrajetDTO trajetDTO) {
        Trajet trajet = trajetMapper.toEntity(trajetDTO);
        Trajet saved = trajetRepository.save(trajet);
        return trajetMapper.toDTO(saved);
    }

    @Override
    public List<TrajetDTO> getAllTrajets() {
        return trajetRepository.findAll()
                .stream()
                .map(trajetMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TrajetDTO getTrajetById(Integer id) {
        Trajet trajet = trajetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trajet not found"));
        return trajetMapper.toDTO(trajet);
    }

    @Override
    public TrajetDTO updateTrajet(Integer id, TrajetDTO trajetDTO) {
        Trajet trajet = trajetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trajet not found"));

        trajet.setDepart(trajetDTO.getDepart());
        trajet.setArriver(trajetDTO.getArriver());
        trajet.setPlaceDisponible(trajetDTO.getPlaceDisponible());
        trajet.setCo2(trajetDTO.getCo2());

        Trajet updated = trajetRepository.save(trajet);
        return trajetMapper.toDTO(updated);
    }

    @Override
    public void deleteTrajet(Integer id) {
        trajetRepository.deleteById(id);
    }
}