package com.example.cinemachain.service;


import com.example.cinemachain.repository.FilmRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    private FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
}
