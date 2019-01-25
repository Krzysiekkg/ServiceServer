package com.krzysiek.repo;

import com.krzysiek.entities.Pylon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PylonRepository extends JpaRepository<Pylon,Long> {

    @Query("SELECT p FROM Pylon p WHERE p.idTask = ?1")
    List<Pylon> findPylonsByTaskId(Long taskid);
}
