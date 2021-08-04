package com.decipherzone.hallmanagement.repository;

import com.decipherzone.hallmanagement.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking,Long> {

}
