package org.binar.seatservice.repository;


import org.binar.seatservice.model.ChairNumber;
import org.binar.seatservice.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Interface repository untuk menghandle semua request ke table seat
 * @author Agustinus
 */
@Repository
@Transactional
public interface SeatsRepository extends JpaRepository<Seats, ChairNumber> {


    @Modifying
    @Query(value = "insert into seats (number, studio, studio_name) values  (:number, :studio, :studioName)", nativeQuery = true)
    void addChairNumber(@Param("number")Integer number,@Param("studio") String studio,@Param("studioName") String studioName);


    @Query(value = "select :number, :studio from seats where studio_name = :studioName", nativeQuery = true)
    List<Seats> getChairNumber(@Param("number")Integer number, @Param("studio") String studio, @Param("studioName") String studioName);
}
