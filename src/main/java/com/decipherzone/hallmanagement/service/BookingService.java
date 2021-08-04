package com.decipherzone.hallmanagement.service;

import com.decipherzone.hallmanagement.model.Booking;
import com.decipherzone.hallmanagement.model.Hall;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();

    Booking newBooking(Booking booking, Long hallId);

    List<Hall> getAvailableHalls(int capacity, LocalDate bookingDate);

    void deleteBooking(Long id);
}
