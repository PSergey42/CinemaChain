package com.example.cinemachain.entity.model;

import com.example.cinemachain.entity.Session;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.sql.Date;

@Data
@AllArgsConstructor
public class SessionPojo {
    private long id;
    private Date showDate;
    private String showTime;
    private int hall;
    private int numberSeats;

    public SessionPojo() {
    }

    public static Session toEntity(SessionPojo sessionPojo) {
        Session session = new Session();
        session.setId(sessionPojo.getId());
        session.setShowDate(sessionPojo.getShowDate());
        session.setShowTime(Time.valueOf(sessionPojo.getShowTime()));
        session.setHall(sessionPojo.getHall());
        session.setNumberSeats(sessionPojo.getNumberSeats());
        return session;
    }

    public static SessionPojo fromEntity(Session session) {
        return new SessionPojo(session.getId(), session.getShowDate(), session.getShowTime().toString(), session.getHall(), session.getNumberSeats());
    }
}
