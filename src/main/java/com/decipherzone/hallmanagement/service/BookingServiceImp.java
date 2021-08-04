package com.decipherzone.hallmanagement.service;

import com.decipherzone.hallmanagement.model.Booking;
import com.decipherzone.hallmanagement.model.Hall;
import com.decipherzone.hallmanagement.repository.BookingRepository;
import com.decipherzone.hallmanagement.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImp implements BookingService{

    private final BookingRepository repository;
    private final HallRepository hallRepository;

    @Autowired
    public BookingServiceImp(BookingRepository repository, HallRepository hallRepository) {
        this.repository = repository;
        this.hallRepository = hallRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return (List<Booking>) repository.findAll();
    }

    @Override
    public Booking newBooking(Booking booking, Long hallId) {
        Optional<Hall> optionalHall = hallRepository.findById(hallId);

        if(optionalHall.isEmpty()){
            //ToDo handle exception
            throw new RuntimeException("Invalid id, hall not found");
        }

        Hall hall = optionalHall.get();
        booking.setHall(hall);
        booking.setBookingDate(LocalDate.now(ZoneId.of("Asia/Kolkata")));
        return repository.save(booking);
    }


    @Override
    public List<Hall> getAvailableHalls(int capacity, LocalDate seminarDate) {

        List<Hall> hallList = hallRepository.findByCapacityAndAvailability(capacity, seminarDate);
        return hallList;
    }

    @Override
    public void deleteBooking(Long id) {
        Optional<Booking> optionalBooking = repository.findById(id);

        if(optionalBooking.isEmpty()){
            //ToDo handle exception
            throw new RuntimeException("Booking cannot be deleted, id not found");
        }

        Booking booking = optionalBooking.get();
        booking.getHall().deleteBooking(booking);
        repository.deleteById(id);
    }
}
