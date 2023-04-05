package com.example.cinemachain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.sql.Date;

@Data
@AllArgsConstructor
@Table(name = "session")
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private long id;
    @ManyToOne()
    @JoinColumn(name = "schedule_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Schedule schedule;
    @Column(name = "show_date")
    private Date showDate;
    @Column(name = "show_time")
    private Time showTime;
    @Column(name = "hall")
    private int hall;
    @Column(name = "number_seats")
    private int numberSeats;

    public Session() {

    }
}
