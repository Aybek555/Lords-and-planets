package com.example.workdemo.services;

import com.example.workdemo.models.Planet;
import com.example.workdemo.repo.PlanetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    @Autowired
    private PlanetRepo planetRepo;

    public Planet create(Planet planet){
        return planetRepo.save(planet);
    }

    public Planet getPlanetById(Long id){
        return planetRepo.findPlanetById(id);
    }

    public void deletePlanet(Long id){
        planetRepo.deleteById(id);
    }

}
