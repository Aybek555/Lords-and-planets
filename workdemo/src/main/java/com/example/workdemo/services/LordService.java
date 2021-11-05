package com.example.workdemo.services;

import com.example.workdemo.models.Lord;
import com.example.workdemo.models.Planet;
import com.example.workdemo.repo.LordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LordService {
    @Autowired
    private LordRepo lordRepo;

    @Autowired
    private PlanetService planetService;

    public Lord create(Lord lord){
    return lordRepo.save(lord);
    }

    public boolean addPlanetToLord(Long lord_id, Long planet_id){
    Lord lord= lordRepo.findLordById(lord_id);
    Planet planet = planetService.getPlanetById(planet_id);
    if(lord==null || planet==null){
        return false;
    }
    lord.getPlanets().add(planet);
    lordRepo.save(lord);
    return true;
    }

    public List<Lord> getLazybones(){
        List<Lord> allLords=lordRepo.findAll();
        List<Lord> lazybones= new ArrayList<>();
        allLords.forEach(lord -> {
            if(lord.getPlanets()==null){
                lazybones.add(lord);
            }
        });
        return lazybones;
    }

    public List<Lord> getTopLords(){
        return lordRepo.getYoungestLords();
    }

}
