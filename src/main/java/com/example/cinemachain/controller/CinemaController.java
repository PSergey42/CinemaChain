package com.example.cinemachain.controller;

import com.example.cinemachain.controller.base.BaseController;
import com.example.cinemachain.dto.CinemaDTO;
import com.example.cinemachain.entity.Cinema;
import com.example.cinemachain.service.CinemaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController extends BaseController<Cinema, CinemaDTO> {

    protected CinemaController(CinemaService service) {
        super(service);
    }

    @GetMapping("/search/{name}")
    public List<CinemaDTO> searchCinemaByName(@PathVariable("name") String name) {
        return ((CinemaService) service).searchCinemaByName(name);
    }
}
