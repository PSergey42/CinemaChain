package com.example.cinemachain.service;

import com.example.cinemachain.converter.GenreConverter;
import com.example.cinemachain.dto.GenreDTO;
import com.example.cinemachain.entity.Genre;
import com.example.cinemachain.repository.GenreRepository;
import com.example.cinemachain.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService extends BaseService<Genre, GenreDTO> {

    public GenreService(GenreRepository repository, GenreConverter converter) {
        super(repository, converter);
    }

    public List<GenreDTO> searchGenreByName(String name) {
        return ((GenreRepository) repository).findAllByNameContainingIgnoreCase(name).stream().map(converter::fromEntity).toList();
    }
}
