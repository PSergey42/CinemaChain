package com.example.cinemachain.repository;

import com.example.cinemachain.entity.Schedule;
import com.example.cinemachain.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends BaseRepository<Schedule> {
    Schedule findByCinemaIdAndFilmId(Long cinemaId, Long filmId);
}
