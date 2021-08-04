package com.decipherzone.hallmanagement.controller;

import com.decipherzone.hallmanagement.model.Booking;
import com.decipherzone.hallmanagement.model.Hall;
import com.decipherzone.hallmanagement.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/hall"})
public class HallController {

    private final HallService hallService;

    @Autowired
    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping({"/getAll"})
    public List<Hall> getHalls(){
        return hallService.getHalls();
    }

    @GetMapping("/{id}")
    public Hall getHall(@PathVariable Long id){
        return hallService.getHall(id);
    }

    @GetMapping("/{id}/bookings")
    public List<Booking> getHallBookings(@PathVariable Long id){
        Hall hall = hallService.getHall(id);
        return hall.getBookings();
    }

    @PostMapping({"/"})
    public Hall newHall(@RequestBody Hall hall){
        return hallService.addOrUpdateHall(hall);
    }

    @PostMapping("/{id}")
    public Hall updateHall(@PathVariable Long id,@RequestBody Hall newHall){
        newHall.setId(id);
        return hallService.addOrUpdateHall(newHall);
    }

    @DeleteMapping("/{id}")
    public void deleteHall(@PathVariable Long id){
        hallService.deleteHall(id);
    }

}
