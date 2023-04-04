package com.example.cinemachain.entity.model;

import com.example.cinemachain.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleV2Pojo {
    private UUID id;
    private UUID filmId;
    private UUID cinemaId;
    private Date showDate;
    private Time showTime;
    private int hall;
    private int numberSeats;

    public static Schedule toEntity(ScheduleV2Pojo scheduleV2Pojo) {
        return new Schedule(scheduleV2Pojo.getId(), scheduleV2Pojo.getFilmId(), scheduleV2Pojo.getCinemaId(), scheduleV2Pojo.getShowDate(),
                scheduleV2Pojo.getShowTime(), scheduleV2Pojo.getHall(), scheduleV2Pojo.getNumberSeats());
    }

    public static ScheduleV2Pojo fromEntity(Schedule schedule) {
        return new ScheduleV2Pojo(schedule.getId(), schedule.getFilmId(), schedule.getCinemaId(), schedule.getShowDate(),
                schedule.getShowTime(), schedule.getHall(), schedule.getNumberSeats());
    }
}
