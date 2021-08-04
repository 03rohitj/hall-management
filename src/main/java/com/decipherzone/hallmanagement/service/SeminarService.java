package com.decipherzone.hallmanagement.service;

import com.decipherzone.hallmanagement.model.Seminar;

import java.time.LocalDate;
import java.util.List;

public interface SeminarService {
    List<Seminar> findSeminars(LocalDate startDate, LocalDate endDate);
}
