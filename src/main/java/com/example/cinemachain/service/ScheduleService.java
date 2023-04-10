package com.example.cinemachain.service;

import com.example.cinemachain.entity.Schedule;
import com.example.cinemachain.entity.model.SchedulePojo;
import com.example.cinemachain.repository.ScheduleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.util.*;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final EntityManager entityManager;

    public ScheduleService(ScheduleRepository scheduleRepository, EntityManager entityManager) {
        this.scheduleRepository = scheduleRepository;
        this.entityManager = entityManager;
    }

    public List<SchedulePojo> getAllSchedules() {
        return scheduleRepository.findAll().stream().map(SchedulePojo::fromEntity).toList();
    }

    // TODO: return 404
    public List<SchedulePojo> getScheduleByCinemaIdAndDate(UUID id, String date) {
        List<Schedule> schedules = entityManager.createQuery(
                "SELECT x FROM Schedule x JOIN FETCH x.sessions WHERE x.cinemaId = :id",
                Schedule.class
        ).setParameter("id", id).getResultList();
        schedules.forEach(s ->
                s.setSessions(s.getSessions().stream().filter(session ->
                        session.getShowDate().equals(Date.valueOf(date))).toList()));
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
        Schedule schedule = SchedulePojo.toEntity(schedulePojo);
        schedule.getSessions().forEach(s -> s.setSchedule(schedule));
        return SchedulePojo.fromEntity(scheduleRepository.save(schedule));
    }

    // TODO: return boolean
    public void deleteSchedule(UUID id) {
        scheduleRepository.deleteById(id);
    }
}
