package com.example.cinemachain.controller;

import com.example.cinemachain.entity.model.CinemaPojo;
import com.example.cinemachain.entity.model.FilmPojo;
import com.example.cinemachain.service.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/cinema")
    public List<CinemaPojo> getAll() {
        return cinemaService.getAllCinemas();
    }

    @GetMapping("/cinema/{id}")
    public CinemaPojo getCinemaById(@PathVariable("id") UUID id) {
        return cinemaService.getCinemaById(id);
    }

    @GetMapping("/cinema/search/{nameCinema}")
    public List<CinemaPojo> searchCinemaByName(@PathVariable("nameCinema") String nameCinema) {
        return cinemaService.searchCinemaByName(nameCinema);
    }

    @PostMapping("/cinema")
    public CinemaPojo addCinema(@RequestBody CinemaPojo cinemaPojo){
        return cinemaService.addCinema(cinemaPojo);
    }

    @PutMapping("/cinema")
    public CinemaPojo updateCinema(@RequestBody CinemaPojo cinemaPojo){
        return cinemaService.updateCinema(cinemaPojo);
    }

    @DeleteMapping ("/cinema/{id}")
    public void deleteCinema(@PathVariable("id") UUID id){
        cinemaService.deleteCinema(id);
    }
}
