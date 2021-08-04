package com.decipherzone.hallmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"booking","professor"})
public class Seminar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;


    @OneToOne(mappedBy = "seminar")
    @JsonIgnore
    Booking booking;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("professor")
    private Professor professor;
}
