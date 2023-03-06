package com.example.cinemachain.controller;

import com.example.cinemachain.entity.model.FilmPojo;
import com.example.cinemachain.service.FilmService;
import org.springframework.web.bind.annotation.*;

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
    public List<FilmPojo> getFilmsByParams(@RequestParam(value = "name", required = false) String nameFilm,
                                           @RequestParam(value = "genres_id", required = false) String genresId,
                                           @RequestParam(value = "actors_id", required = false) String actorsId,
                                           @RequestParam(value = "budgets", required = false) String budgets) {
        return filmService.getFilmsByParams(nameFilm, genresId, actorsId, budgets);
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

    @PutMapping("/film/{film_id}/addActor/{id}")
    public FilmPojo addActorInFilm(@PathVariable("film_id") UUID filmId, @PathVariable("id") UUID id){
        return filmService.addActorInFilm(filmId, id);
    }

    @DeleteMapping ("/film/{film_id}/deleteActor/{id}")
    public void deleteActorFromFilm(@PathVariable("film_id") UUID filmId, @PathVariable("id") UUID id){
        filmService.deleteActorFromFilm(filmId, id);
    }

    @PutMapping("/film/{film_id}/addGenre/{id}")
    public FilmPojo addGenreInFilm(@PathVariable("film_id") UUID filmId, @PathVariable("id") UUID id){
        return filmService.addGenreInFilm(filmId, id);
    }

    @DeleteMapping ("/film/{film_id}/deleteGenre/{id}")
    public void deleteGenreFromFilm(@PathVariable("film_id") UUID filmId, @PathVariable("id") UUID id){
        filmService.deleteGenreFromFilm(filmId, id);
    }
}
