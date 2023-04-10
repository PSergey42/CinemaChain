package com.example.cinemachain.repository;

import com.example.cinemachain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {

    //TODO переделать на join
    @Query(value = "SELECT x.schedule_id, x.film_id, x.cinema_id FROM schedule x JOIN \"session\" s ON x.schedule_id = s.schedule_id AND s.show_date = :date WHERE x.cinema_id = :id", nativeQuery = true)
    List<Schedule> findByCinemaIdaAndSessionsDate(UUID id, Date date);
    List<Schedule> findByCinemaId(UUID id);
}
