package com.decipherzone.hallmanagement.controller;

import com.decipherzone.hallmanagement.model.Booking;
import com.decipherzone.hallmanagement.model.Hall;
import com.decipherzone.hallmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping({"/",""})
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @PostMapping({"/{hallId}"})
    public Booking newBooking(@PathVariable Long hallId, @RequestBody Booking booking){
        return bookingService.newBooking(booking, hallId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/list_availability")
    public List<Hall> getAvailableHalls(@RequestBody Map<String,String> payload){
        int capacity = Integer.valueOf(payload.get("capacity"));
        final LocalDate seminarDate = LocalDate.parse(payload.get("date"));
        return bookingService.getAvailableHalls(capacity,seminarDate);
    }

}
