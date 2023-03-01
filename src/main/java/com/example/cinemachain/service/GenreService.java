package com.example.cinemachain.service;

import com.example.cinemachain.repository.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
}
