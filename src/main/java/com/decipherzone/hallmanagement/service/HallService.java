package com.decipherzone.hallmanagement.service;

import com.decipherzone.hallmanagement.model.Hall;

import java.util.List;

public interface HallService {
    List<Hall> getHalls();

    Hall addOrUpdateHall(Hall hall);

    Hall getHall(Long id);

    void deleteHall(Long id);
}
