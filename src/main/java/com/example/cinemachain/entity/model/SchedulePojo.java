package com.example.cinemachain.entity.model;

import com.example.cinemachain.entity.Actor;
import com.example.cinemachain.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class SchedulePojo {
    private UUID id;
    private UUID filmId;
    private UUID cinemaId;
    private Date showDate;
    private Time showTime;
    private int hall;
    private int numberSeats;

    public SchedulePojo() {

    }

    public static Schedule toEntity(SchedulePojo schedulePojo) {
        return new Schedule(schedulePojo.getId(), schedulePojo.getFilmId(), schedulePojo.getCinemaId(), schedulePojo.getShowDate(),
                schedulePojo.getShowTime(), schedulePojo.getHall(), schedulePojo.getNumberSeats());
    }

    public static SchedulePojo fromEntity(Schedule schedule) {
        return new SchedulePojo(schedule.getId(), schedule.getFilmId(), schedule.getCinemaId(), schedule.getShowDate(),
                schedule.getShowTime(), schedule.getHall(), schedule.getNumberSeats());
    }
}
