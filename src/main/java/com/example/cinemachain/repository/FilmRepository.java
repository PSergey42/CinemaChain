package com.example.cinemachain.repository;

import com.example.cinemachain.entity.Film;
import com.example.cinemachain.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends BaseRepository<Film> {
    List<Film> findAllByNameContainingIgnoreCase(String name);
}
