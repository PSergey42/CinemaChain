package com.example.cinemachain.service;

import com.example.cinemachain.repository.CinemaRepository;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    private CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }
}
