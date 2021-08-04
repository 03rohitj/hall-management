package com.decipherzone.hallmanagement.bootstrap;

import com.decipherzone.hallmanagement.model.Booking;
import com.decipherzone.hallmanagement.model.Hall;
import com.decipherzone.hallmanagement.model.Professor;
import com.decipherzone.hallmanagement.model.Seminar;
import com.decipherzone.hallmanagement.repository.BookingRepository;
import com.decipherzone.hallmanagement.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final HallRepository hallRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public DummyDataBootstrap(HallRepository hallRepository, BookingRepository bookingRepository) {
        this.hallRepository = hallRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        bookingRepository.saveAll(getBookings());
    }

    public List<Booking> getBookings(){
        List<Booking> bookingList = new ArrayList<>();
        Hall h1 = new Hall();
        h1.setId(1L);
        h1.setCapacity(2500);
        h1.setName("Hall A");

        Hall h2 = new Hall();
        h2.setId(2L);
        h2.setCapacity(2000);
        h2.setName("Hall B");

        Hall h3 = new Hall();
        h3.setId(3L);
        h3.setCapacity(3000);
        h3.setName("Hall C");

        Hall h4 = new Hall();
        h4.setId(4L);
        h4.setCapacity(500);
        h4.setName("Hall D");

        hallRepository.save(h1);
        hallRepository.save(h2);
        hallRepository.save(h3);
        hallRepository.save(h4);

        Booking b1 = new Booking();
        b1.setId(1L);
        b1.setBookingDate(LocalDate.of(2021,8,21));
        b1.setHall(h1);

        Booking b2 = new Booking();
        b2.setId(2L);
        b2.setBookingDate(LocalDate.of(2021,8,28));
        b2.setHall(h2);

        Booking b3 = new Booking();
        b3.setId(3L);
        b3.setBookingDate(LocalDate.of(2021,8,30));
        b3.setHall(h3);

        Booking b4 = new Booking();
        b4.setId(4L);
        b4.setBookingDate(LocalDate.of(2021,8,30));
        b4.setHall(h1);

        Seminar s1 = new Seminar();
        s1.setId(1L);
        s1.setDate(LocalDate.of(2021,9,5));
        s1.setProfessor(new Professor(1L,"Professor A"));
        s1.setTitle("Title A");
        s1.setStartTime(LocalTime.of(12,00,00));
        s1.setEndTime(LocalTime.of(14,30,00));


        Seminar s2 = new Seminar();
        s2.setId(2L);
        s2.setDate(LocalDate.of(2021,9,8));
        s2.setProfessor(new Professor(2L,"Professor B"));
        s2.setTitle("Title B");
        s2.setStartTime(LocalTime.of(18,00,00));
        s2.setEndTime(LocalTime.of(20,00,00));

        Seminar s3 = new Seminar();
        s3.setId(3L);
        s3.setDate(LocalDate.of(2021,9,15));
        s3.setProfessor(new Professor(3L,"Professor C"));
        s3.setTitle("Title C");
        s3.setStartTime(LocalTime.of(14,00,00));
        s3.setEndTime(LocalTime.of(16,00,00));

        Seminar s4 = new Seminar();
        s4.setId(4L);
        s4.setDate(LocalDate.of(2021,9,18));
        s4.setProfessor(new Professor(4L,"Professor D"));
        s4.setTitle("Title D");
        s4.setStartTime(LocalTime.of(10,00,00));
        s4.setEndTime(LocalTime.of(12,30,00));

        b1.setSeminar(s1);
        b2.setSeminar(s2);
        b3.setSeminar(s3);
        b4.setSeminar(s4);

        bookingList.add(b1);
        bookingList.add(b2);
        bookingList.add(b3);
        bookingList.add(b4);


        return bookingList;
    }

}
