package com.example.workdemo.controllers;

import com.example.workdemo.forms.PlanetToLordForm;
import com.example.workdemo.models.Lord;
import com.example.workdemo.models.Planet;
import com.example.workdemo.services.LordService;
import com.example.workdemo.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LordController {
    @Autowired
    private LordService lordService;

    @Autowired
    private PlanetService planetService;

    @PostMapping("/lord/create")
    public ResponseEntity create(@RequestBody Lord lord){
        return ResponseEntity.ok().body(lordService.create(lord));
    }

    @PostMapping("/lord/addplanet")
    public ResponseEntity addPlanetToLord(@RequestBody PlanetToLordForm form){
        boolean result= lordService.addPlanetToLord(form.getLord_id(), form.getPlanet_id());
        if(result){
            return ResponseEntity.ok("Added!");
        }
        return ResponseEntity.badRequest().body("Something went wrong!");
    }

    @PostMapping("planet/delete")
    public ResponseEntity deletePlanet(@RequestParam Long id){
        planetService.deletePlanet(id);
        return ResponseEntity.ok().body("Deleted!");
    }

    @PostMapping("/planet/create")
    public ResponseEntity planetCreate(@RequestBody Planet planet){
        return ResponseEntity.ok().body(planetService.create(planet));
    }

    @GetMapping("/lord/lazybones")
    public ResponseEntity<List<Lord>> getLazybones(){
        return ResponseEntity.ok().body(lordService.getLazybones());
    }
    @GetMapping("/lord/youngest")
    public ResponseEntity<List<Lord>> getYoungsters(){
        return ResponseEntity.ok().body(lordService.getTopLords());
    }
}
