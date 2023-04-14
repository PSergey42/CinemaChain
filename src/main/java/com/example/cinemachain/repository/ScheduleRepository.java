package com.example.cinemachain.repository;

import com.example.cinemachain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {
    Schedule findByCinemaIdAndFilmId(UUID cinemaId, UUID filmId);
}
