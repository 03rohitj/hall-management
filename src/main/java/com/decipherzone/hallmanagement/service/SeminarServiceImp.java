package com.decipherzone.hallmanagement.service;

import com.decipherzone.hallmanagement.model.Seminar;
import com.decipherzone.hallmanagement.repository.SeminarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SeminarServiceImp implements SeminarService{
    private final SeminarRepository seminarRepository;

    @Autowired
    public SeminarServiceImp(SeminarRepository seminarRepository) {
        this.seminarRepository = seminarRepository;
    }

    @Override
    public List<Seminar> findSeminars(LocalDate startDate, LocalDate endDate) {
        return seminarRepository.findSeminars(startDate,endDate);
    }
}
