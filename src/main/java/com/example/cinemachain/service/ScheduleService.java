package com.example.cinemachain.service;

import com.example.cinemachain.entity.Schedule;
import com.example.cinemachain.entity.model.SchedulePojo;
import com.example.cinemachain.entity.model.ScheduleV2Pojo;
import com.example.cinemachain.entity.model.SessionPojo;
import com.example.cinemachain.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleV2Pojo> getAllSchedules() {
        return scheduleRepository.findAll().stream().map(ScheduleV2Pojo::fromEntity).toList();
    }

    // TODO: return 404
    public List<SchedulePojo> getScheduleByCinemaId(UUID id) {
        var schedules = scheduleRepository.findByCinemaId(id);
        if(schedules.isEmpty()){
            return null;
        }
        HashMap<UUID, SchedulePojo> list = new HashMap<>();
        for (Schedule schedule: schedules){
            if(list.containsKey(schedule.getFilmId())){
                list.get(schedule.getFilmId()).getSessions().add(new SessionPojo(schedule.getShowDate(), schedule.getShowTime(), schedule.getHall(), schedule.getNumberSeats()));
            }
            else {
                list.put(schedule.getFilmId(), new SchedulePojo(schedule.getId(), schedule.getFilmId(), schedule.getCinemaId(),
                        List.of(new SessionPojo(schedule.getShowDate(), schedule.getShowTime(), schedule.getHall(), schedule.getNumberSeats()))));
            }
        }
        return list.values().stream().toList();
    }


    public ScheduleV2Pojo addSchedule(ScheduleV2Pojo schedulePojo) {
        schedulePojo.setId(UUID.randomUUID());
        return ScheduleV2Pojo.fromEntity(scheduleRepository.save(ScheduleV2Pojo.toEntity(schedulePojo)));
    }

    public ScheduleV2Pojo updateSchedule(ScheduleV2Pojo schedulePojo) {
        return ScheduleV2Pojo.fromEntity(scheduleRepository.save(ScheduleV2Pojo.toEntity(schedulePojo)));
    }

    // TODO: return boolean
    public void deleteSchedule(UUID id) {
        scheduleRepository.deleteById(id);
    }
}
