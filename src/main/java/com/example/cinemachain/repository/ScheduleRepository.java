package com.example.cinemachain.repository;

import com.example.cinemachain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {

    //TODO переделать на join
    @Query(value = "SELECT schedule_id, film_id, cinema_id, (SELECT * FROM session s WHERE s.schedule_id = schedule_id AND s.show_date = :date) FROM schedule WHERE cinema_id = :id", nativeQuery = true)
    List<Schedule> findByCinemaIdaAndSessionsDate(UUID id, Date date);
}
