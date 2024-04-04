package com.example.cinemachain.controller;

import com.example.cinemachain.controller.base.BaseController;
import com.example.cinemachain.dto.FilmDTO;
import com.example.cinemachain.entity.Film;
import com.example.cinemachain.service.FilmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmController extends BaseController<Film, FilmDTO> {

    protected FilmController(FilmService service) {
        super(service);
    }

    @GetMapping("/filmsByParams")
    public List<FilmDTO> getFilmsByParams(@RequestParam(value = "name", required = false) String nameFilm,
                                          @RequestParam(value = "genres_id", required = false) String genresId,
                                          @RequestParam(value = "actors_id", required = false) String actorsId,
                                          @RequestParam(value = "budgets", required = false) String budgets) {
        return ((FilmService) service).getFilmsByParams(nameFilm, genresId, actorsId, budgets);
    }

    @PutMapping("/{film_id}/addActor/{id}")
    public FilmDTO addActorInFilm(@PathVariable("film_id") Long filmId, @PathVariable("id") Long id){
        return ((FilmService) service).addActorInFilm(filmId, id);
    }

    @DeleteMapping ("/{film_id}/deleteActor/{id}")
    public void deleteActorFromFilm(@PathVariable("film_id") Long filmId, @PathVariable("id") Long id){
        ((FilmService) service).deleteActorFromFilm(filmId, id);
    }

    @PutMapping("/{film_id}/addGenre/{id}")
    public FilmDTO addGenreInFilm(@PathVariable("film_id") Long filmId, @PathVariable("id") Long id){
        return ((FilmService) service).addGenreInFilm(filmId, id);
    }

    @DeleteMapping ("/{film_id}/deleteGenre/{id}")
    public void deleteGenreFromFilm(@PathVariable("film_id") Long filmId, @PathVariable("id") Long id){
        ((FilmService) service).deleteGenreFromFilm(filmId, id);
    }
}
