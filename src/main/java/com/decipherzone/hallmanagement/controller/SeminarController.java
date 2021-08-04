package com.decipherzone.hallmanagement.controller;

import com.decipherzone.hallmanagement.model.Seminar;
import com.decipherzone.hallmanagement.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/seminar","seminars"})
public class SeminarController {
    private SeminarService seminarService;

    @Autowired
    public SeminarController(SeminarService seminarService) {
        this.seminarService = seminarService;
    }

    @PostMapping({"/",""})
    public List<Seminar> getSeminars(@RequestBody Map<String, String> seminarDates){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(seminarDates.get("startDate"),dtf);
        LocalDate endDate = LocalDate.parse(seminarDates.get("endDate"),dtf);

        return seminarService.findSeminars(startDate, endDate);
    }
}