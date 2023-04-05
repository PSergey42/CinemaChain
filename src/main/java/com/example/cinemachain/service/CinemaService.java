package com.example.cinemachain.service;

import com.example.cinemachain.entity.model.CinemaPojo;
import com.example.cinemachain.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public List<CinemaPojo> getAllCinemas() {
        return cinemaRepository.findAll().stream().map(CinemaPojo::fromEntity).toList();
    }

    // TODO: return 404
    public CinemaPojo getCinemaById(UUID id) {
        var cinema = cinemaRepository.findById(id);
        if(cinema.isEmpty()){
            return null;
        }
        return CinemaPojo.fromEntity(cinema.get());
    }

    public List<CinemaPojo> searchCinemaByName(String nameCinema) {
        return cinemaRepository.findAllByNameContainingIgnoreCase(nameCinema).stream().map(CinemaPojo::fromEntity).toList();
    }

    public CinemaPojo addCinema(CinemaPojo cinemaPojo) {
        cinemaPojo.setId(UUID.randomUUID());
        return CinemaPojo.fromEntity(cinemaRepository.save(CinemaPojo.toEntity(cinemaPojo)));
    }

    public CinemaPojo updateCinema(CinemaPojo cinemaPojo) {
        return CinemaPojo.fromEntity(cinemaRepository.save(CinemaPojo.toEntity(cinemaPojo)));
    }

    // TODO: return boolean
    public void deleteCinema(UUID id) {
        cinemaRepository.deleteById(id);
    }
}
