package com.example.workdemo.repo;

import com.example.workdemo.models.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LordRepo extends JpaRepository<Lord, Long> {
    Lord findLordById(Long id);

    @Modifying
    @Query(value = "SELECT * FROM lord ORDER BY age ASC LIMIT 0, 10", nativeQuery = true)
    List<Lord> getYoungestLords();
}
