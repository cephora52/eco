package com.example.ecomove.services.interfaces;

import com.example.ecomove.dto.TrajetDTO;
import java.util.List;

public interface TrajetInterface {

    TrajetDTO createTrajet(TrajetDTO trajetDTO);

    List<TrajetDTO> getAllTrajets();

    TrajetDTO getTrajetById(Integer id);

    TrajetDTO updateTrajet(Integer id, TrajetDTO trajetDTO);

    void deleteTrajet(Integer id);
}