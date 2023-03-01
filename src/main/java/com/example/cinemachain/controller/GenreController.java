package com.example.cinemachain.controller;


import com.example.cinemachain.service.GenreService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {
    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
}
