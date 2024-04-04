package com.example.cinemachain.repository;

import com.example.cinemachain.entity.Cinema;
import com.example.cinemachain.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends BaseRepository<Cinema> {
    List<Cinema> findAllByNameContainingIgnoreCase(String name);
}
