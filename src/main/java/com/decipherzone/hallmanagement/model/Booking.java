package com.decipherzone.hallmanagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Hall hall;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("seminar")
    private Seminar seminar;

    @JsonProperty("bookingDate")
    LocalDate bookingDate;

    public Booking() {
    }

}
