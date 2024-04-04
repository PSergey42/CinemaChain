package com.example.cinemachain.controller;

import com.example.cinemachain.controller.base.BaseController;
import com.example.cinemachain.dto.GenreDTO;
import com.example.cinemachain.entity.Genre;
import com.example.cinemachain.service.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController extends BaseController<Genre, GenreDTO> {

    protected GenreController(GenreService service) {
        super(service);
    }

    @GetMapping("/search/{name}")
    public List<GenreDTO> searchGenreByName(@PathVariable("name") String name) {
        return ((GenreService) service).searchGenreByName(name);
    }
}
