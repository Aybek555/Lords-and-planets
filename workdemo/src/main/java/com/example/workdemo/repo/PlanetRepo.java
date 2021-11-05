package com.example.workdemo.repo;

import com.example.workdemo.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepo extends JpaRepository<Planet, Long> {
 Planet findPlanetById(Long id);

 @Override
 void deleteById(Long id);
}
