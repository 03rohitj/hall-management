package com.decipherzone.hallmanagement.service;

import com.decipherzone.hallmanagement.model.Hall;
import com.decipherzone.hallmanagement.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallServiceImp implements HallService{

    private final HallRepository repository;

    @Autowired
    public HallServiceImp(HallRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Hall> getHalls() {
        return (List<Hall>) repository.findAll();
    }

    @Override
    public Hall addOrUpdateHall(Hall hall) {
        return repository.save(hall);
    }

    @Override
    public Hall getHall(Long id) {
        Optional<Hall> optionalHall = repository.findById(id);
        return optionalHall.orElseThrow();

    }

    @Override
    public void deleteHall(Long id) {
        repository.deleteById(id);
    }
}
