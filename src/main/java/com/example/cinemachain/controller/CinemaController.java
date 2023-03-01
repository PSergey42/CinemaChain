package com.example.cinemachain.controller;

import com.example.cinemachain.service.CinemaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    private CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }
}
