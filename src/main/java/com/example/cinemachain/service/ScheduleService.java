package com.example.cinemachain.service;

import com.example.cinemachain.converter.ScheduleConverter;
import com.example.cinemachain.dto.ScheduleDTO;
import com.example.cinemachain.entity.Schedule;
import com.example.cinemachain.repository.ScheduleRepository;
import com.example.cinemachain.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleService extends BaseService<Schedule, ScheduleDTO> {
    public ScheduleService(ScheduleRepository repository, ScheduleConverter converter) {
        super(repository, converter);
    }

    public List<ScheduleDTO> getScheduleByCinemaIdAndDate(Long id, String date) {
        List<Schedule> schedules = em.createQuery(
                "SELECT x FROM Schedule x JOIN FETCH x.sessions WHERE x.cinemaId = :id",
                Schedule.class
        ).setParameter("id", id).getResultList();
        filterScheduleByDate(schedules, date);
        if(schedules.isEmpty()){
            return null;
        }
        return schedules.stream().map(converter::fromEntity).toList();
    }

    public List<ScheduleDTO> searchScheduleByName(Long id, String nameSchedule, String date) {
        List<Schedule> schedules = em.createQuery(
                "SELECT x FROM Schedule x JOIN FETCH x.sessions WHERE x.cinemaId = :id AND (SELECT UPPER(f.name) FROM Film f WHERE f.id = x.filmId) LIKE UPPER(:nameSchedule)",
                Schedule.class
        ).setParameter("id", id)
                .setParameter("nameSchedule", "%" + nameSchedule + "%").getResultList();
        filterScheduleByDate(schedules, date);
        if(schedules.isEmpty()){
            return null;
        }
        return schedules.stream().map(converter::fromEntity).toList();
    }

    private void filterScheduleByDate(List<Schedule> schedules, String date){
        schedules.forEach(s ->
                s.setSessions(s.getSessions().stream().filter(session ->
                        session.getShowDate().equals(LocalDate.parse(date))).toList()));
        schedules.removeIf(schedule -> schedule.getSessions().size() == 0);
    }
}
