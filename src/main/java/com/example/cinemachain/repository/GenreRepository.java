package com.example.cinemachain.repository;

import com.example.cinemachain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GenreRepository extends JpaRepository<Genre, UUID> {
    List<Genre> findAllByNameContainingIgnoreCase(String nameGenre);
}
