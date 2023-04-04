package com.example.cinemachain.entity.model;

import com.example.cinemachain.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class SchedulePojo {
    private UUID id;
    private UUID filmId;
    private UUID cinemaId;
    private List<SessionPojo> sessions;


    public SchedulePojo() {

    }


}
