package com.example.cinemachain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@Table (name = "schedule")
@Entity
public class Schedule {
    @Id
    @Column(name = "schedule_id")
    private UUID id;
    @Column(name = "film_id")
    private UUID filmId;
    @Column(name = "cinema_id")
    private UUID cinemaId;
    @Column(name = "show_date")
    private Date showDate;
    @Column(name = "show_time")
    private Time showTime;
    @Column(name = "hall")
    private int hall;
    @Column(name = "number_seats")
    private int numberSeats;

    public Schedule() {

    }
}
