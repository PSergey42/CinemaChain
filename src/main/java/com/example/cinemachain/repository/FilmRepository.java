package com.example.cinemachain.repository;

import com.example.cinemachain.entity.Film;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, UUID> {

    List<Film> findAllByNameContainingIgnoreCase(String name);

}
