package com.example.cinemachain.service;

import com.example.cinemachain.entity.Schedule;
import com.example.cinemachain.entity.model.SchedulePojo;
import com.example.cinemachain.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<SchedulePojo> getAllSchedules() {
        return scheduleRepository.findAll().stream().map(SchedulePojo::fromEntity).toList();
    }

    // TODO: return 404
    public List<SchedulePojo> getScheduleByCinemaIdAndDate(UUID id, String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        var schedules = scheduleRepository.findByCinemaIdaAndSessionsDate(id, dateFormat.parse(date));
        if(schedules.isEmpty()){
            return null;
        }
        return schedules.stream().map(SchedulePojo::fromEntity).toList();
    }


    public SchedulePojo addSchedule(SchedulePojo schedulePojo) {
        schedulePojo.setId(UUID.randomUUID());
        Schedule schedule = SchedulePojo.toEntity(schedulePojo);
        schedule.getSessions().forEach(s -> s.setSchedule(schedule));
        return SchedulePojo.fromEntity(scheduleRepository.save(schedule));
    }

    public SchedulePojo updateSchedule(SchedulePojo schedulePojo) {
        return SchedulePojo.fromEntity(scheduleRepository.save(SchedulePojo.toEntity(schedulePojo)));
    }

    // TODO: return boolean
    public void deleteSchedule(UUID id) {
        scheduleRepository.deleteById(id);
    }
}
