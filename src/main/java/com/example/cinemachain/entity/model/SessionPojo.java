package com.example.cinemachain.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
public class SessionPojo {
    private Date showDate;
    private Time showTime;
    private int hall;
    private int numberSeats;

    public SessionPojo() {

    }


}
