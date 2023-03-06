package com.example.cinemachain.service;

import com.example.cinemachain.entity.model.ActorPojo;
import com.example.cinemachain.entity.model.FilmPojo;
import com.example.cinemachain.entity.model.SchedulePojo;
import com.example.cinemachain.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<SchedulePojo> getAllSchedules() {
        return scheduleRepository.findAll().stream().map(SchedulePojo::fromEntity).toList();
    }

    // TODO: return 404
    public SchedulePojo getScheduleById(UUID id) {
        var schedule = scheduleRepository.findById(id);
        if(schedule.isEmpty()){
            return null;
        }
        return SchedulePojo.fromEntity(schedule.get());
    }

    public SchedulePojo addSchedule(SchedulePojo schedulePojo) {
        schedulePojo.setId(UUID.randomUUID());
        return SchedulePojo.fromEntity(scheduleRepository.save(SchedulePojo.toEntity(schedulePojo)));
    }

    public SchedulePojo updateSchedule(SchedulePojo schedulePojo) {
        return SchedulePojo.fromEntity(scheduleRepository.save(SchedulePojo.toEntity(schedulePojo)));
    }

    // TODO: return boolean
    public void deleteSchedule(UUID id) {
        scheduleRepository.deleteById(id);
    }
}
