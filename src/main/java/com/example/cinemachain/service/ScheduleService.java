package com.example.cinemachain.service;

import com.example.cinemachain.entity.Schedule;
import com.example.cinemachain.entity.model.SchedulePojo;
import com.example.cinemachain.repository.ScheduleRepository;
import com.example.cinemachain.repository.SessionRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final SessionRepository sessionRepository;
    private final EntityManager entityManager;

    public ScheduleService(ScheduleRepository scheduleRepository, SessionRepository sessionRepository, EntityManager entityManager) {
        this.scheduleRepository = scheduleRepository;
        this.sessionRepository = sessionRepository;
        this.entityManager = entityManager;
    }

    public List<SchedulePojo> getAllSchedules() {
        return scheduleRepository.findAll().stream().map(SchedulePojo::fromEntity).toList();
    }

    public List<SchedulePojo> getScheduleByCinemaIdAndDate(UUID id, String date) {
        List<Schedule> schedules = entityManager.createQuery(
                "SELECT x FROM Schedule x JOIN FETCH x.sessions WHERE x.cinemaId = :id",
                Schedule.class
        ).setParameter("id", id).getResultList();
        filterScheduleByDate(schedules, date);
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

    // TODO: return boolean
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }

    public List<SchedulePojo> searchScheduleByName(UUID id, String nameSchedule, String date) {
        List<Schedule> schedules = entityManager.createQuery(
                "SELECT x FROM Schedule x JOIN FETCH x.sessions WHERE x.cinemaId = :id AND (SELECT UPPER(f.name) FROM Film f WHERE f.id = x.filmId) LIKE UPPER(:nameSchedule)",
                Schedule.class
        ).setParameter("id", id)
                .setParameter("nameSchedule", "%" + nameSchedule + "%").getResultList();
        filterScheduleByDate(schedules, date);
        if(schedules.isEmpty()){
            return null;
        }
        return schedules.stream().map(SchedulePojo::fromEntity).toList();
    }

    private void filterScheduleByDate(List<Schedule> schedules, String date){
        schedules.forEach(s ->
                s.setSessions(s.getSessions().stream().filter(session ->
                        session.getShowDate().equals(Date.valueOf(date))).toList()));
        schedules.removeIf(schedule -> schedule.getSessions().size() == 0);
    }
}
