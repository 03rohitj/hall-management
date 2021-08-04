package com.decipherzone.hallmanagement.repository;

import com.decipherzone.hallmanagement.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HallRepository extends JpaRepository<Hall,Long>, JpaSpecificationExecutor<Hall> {
    @Query("SELECT a FROM Hall a WHERE a.capacity>=:capacity AND" +
            " a.id NOT IN (SELECT  b.hall.id FROM Booking b WHERE b.seminar.date=:seminarDate)")
    List<Hall> findByCapacityAndAvailability(@Param("capacity") int capacity, @Param("seminarDate")LocalDate date);

    //List<Hall> findAllByCapacityGreaterThanEqual(Integer capacity);

    List<Hall> findAllByCapacityGreaterThanEqualAndBookingsIsNotIn(Integer capacity,LocalDate date);


}
