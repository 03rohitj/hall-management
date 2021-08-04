package com.decipherzone.hallmanagement.repository;

import com.decipherzone.hallmanagement.model.Seminar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SeminarRepository extends CrudRepository<Seminar, Long> {

    @Query("SELECT a from Seminar a where a.date BETWEEN :startDate AND :endDate")
    List<Seminar> findSeminars(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
