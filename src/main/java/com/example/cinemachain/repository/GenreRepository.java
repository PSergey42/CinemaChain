package com.example.cinemachain.repository;

import com.example.cinemachain.entity.Genre;
import com.example.cinemachain.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends BaseRepository<Genre> {
    List<Genre> findAllByNameContainingIgnoreCase(String name);
}
