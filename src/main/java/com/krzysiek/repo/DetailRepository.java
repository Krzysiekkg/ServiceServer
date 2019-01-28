package com.krzysiek.repo;

import com.krzysiek.entities.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Details, Long> {


    List<Details> findByPylonPylonId(Long pylonId);
    //ogarnąć co to ten case:)
    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN 'true' ELSE 'false' END FROM Details d WHERE d.detailId = ?1")
    Boolean existsByDetailsId(Long id);
    @Transactional
    @Modifying
    @Query("update Details d set d.status = ?1 where d.detailId = ?2")
    void setDetailsStatus(int status, Long detailsId);
}
