package com.example.cinemachain.service;

import com.example.cinemachain.converter.CinemaConverter;
import com.example.cinemachain.dto.CinemaDTO;
import com.example.cinemachain.entity.Cinema;
import com.example.cinemachain.repository.CinemaRepository;
import com.example.cinemachain.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService extends BaseService<Cinema, CinemaDTO> {

    public CinemaService(CinemaRepository repository, CinemaConverter converter) {
        super(repository, converter);
    }

    public List<CinemaDTO> searchCinemaByName(String name) {
        return ((CinemaRepository) repository).findAllByNameContainingIgnoreCase(name).stream().map(converter::fromEntity).toList();
    }
}
