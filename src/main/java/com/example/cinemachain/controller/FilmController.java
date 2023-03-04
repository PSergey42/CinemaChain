package com.example.cinemachain.controller;

import com.example.cinemachain.entity.model.FilmPojo;
import com.example.cinemachain.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class FilmController {
    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public List<FilmPojo> getAll() {
        return filmService.getAllFilms();
    }

    @GetMapping("/film/{id}")
    public FilmPojo getFilmById(@PathVariable("id") UUID id) {
        return filmService.getFilmById(id);
    }

    @GetMapping("/filmsByParams")
    public List<FilmPojo> getFilmsByParams(@RequestParam(value = "name") String nameFilm,
                                           @RequestParam(value = "genres_id") String genresId,
                                           @RequestParam(value = "actors_id") String actorsId,
                                           @RequestParam(value = "budgets") String budgets) {
        return filmService.getFilmsByParams(nameFilm, genresId, actorsId, budgets);
    }

    @GetMapping("/filmByName/{nameFilm}")
    public List<FilmPojo> searchFilmByName(@PathVariable("nameFilm") String nameFilm) {
        return filmService.searchFilmByName(nameFilm);
    }

    @PutMapping("/film")
    public FilmPojo addFilm(@RequestBody FilmPojo filmPojo){
        return filmService.addFilm(filmPojo);
    }

    @PostMapping("/film")
    public FilmPojo updateFilm(@RequestBody FilmPojo filmPojo){
        return filmService.updateFilm(filmPojo);
    }

    @DeleteMapping ("/film/{id}")
    public void deleteFilm(@PathVariable("id") UUID id){
        filmService.deleteFilm(id);
    }
}
