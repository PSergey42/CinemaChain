package com.example.cinemachain.controller;

import com.example.cinemachain.service.FilmService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {
    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }
}
