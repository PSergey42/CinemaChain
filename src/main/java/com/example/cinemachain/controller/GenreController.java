package com.example.cinemachain.controller;

import com.example.cinemachain.entity.model.GenrePojo;
import com.example.cinemachain.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genre")
    public List<GenrePojo> getAll() {
        return genreService.getAllGenres();
    }

    @GetMapping("/genre/{id}")
    public GenrePojo getGenreById(@PathVariable("id") UUID id) {
        return genreService.getGenreById(id);
    }

    @GetMapping("/genre/search/{nameGenre}")
    public List<GenrePojo> searchGenreByName(@PathVariable("nameGenre") String nameGenre) {
        return genreService.searchGenreByName(nameGenre);
    }

    @PostMapping("/genre")
    public GenrePojo addGenre(@RequestBody GenrePojo genrePojo){
        return genreService.addGenre(genrePojo);
    }

    @PutMapping("/genre")
    public GenrePojo updateGenre(@RequestBody GenrePojo genrePojo){
        return genreService.updateGenre(genrePojo);
    }

    @DeleteMapping ("/genre/{id}")
    public void deleteGenre(@PathVariable("id") UUID id){
        genreService.deleteGenre(id);
    }
}
