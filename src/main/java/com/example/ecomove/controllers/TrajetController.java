package com.example.ecomove.controllers;

import com.example.ecomove.dto.TrajetDTO;
import com.example.ecomove.services.interfaces.TrajetInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trajets")
public class TrajetController {

    private final TrajetInterface trajetService;

    public TrajetController(TrajetInterface trajetService) {
        this.trajetService = trajetService;
    }

    @PostMapping
    public TrajetDTO createTrajet(@RequestBody TrajetDTO trajetDTO) {
        return trajetService.createTrajet(trajetDTO);
    }

    @GetMapping
    public List<TrajetDTO> getAllTrajets() {
        return trajetService.getAllTrajets();
    }

    @GetMapping("/{id}")
    public TrajetDTO getTrajetById(@PathVariable Integer id) {
        return trajetService.getTrajetById(id);
    }

    @PutMapping("/{id}")
    public TrajetDTO updateTrajet(@PathVariable Integer id,
                                  @RequestBody TrajetDTO trajetDTO) {
        return trajetService.updateTrajet(id, trajetDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTrajet(@PathVariable Integer id) {
        trajetService.deleteTrajet(id);
    }
}
