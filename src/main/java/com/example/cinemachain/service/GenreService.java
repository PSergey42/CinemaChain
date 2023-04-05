package com.example.cinemachain.service;

import com.example.cinemachain.entity.model.ActorPojo;
import com.example.cinemachain.entity.model.FilmPojo;
import com.example.cinemachain.entity.model.GenrePojo;
import com.example.cinemachain.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<GenrePojo> getAllGenres() {
        return genreRepository.findAll().stream().map(GenrePojo::fromEntity).toList();
    }

    // TODO: return 404
    public GenrePojo getGenreById(UUID id) {
        var genre = genreRepository.findById(id);
        if(genre.isEmpty()){
            return null;
        }
        return GenrePojo.fromEntity(genre.get());
    }

    public List<GenrePojo> searchGenreByName(String nameGenre) {
        return genreRepository.findAllByNameContainingIgnoreCase(nameGenre).stream().map(GenrePojo::fromEntity).toList();
    }

    public GenrePojo addGenre(GenrePojo genrePojo) {
        genrePojo.setId(UUID.randomUUID());
        return GenrePojo.fromEntity(genreRepository.save(GenrePojo.toEntity(genrePojo)));
    }

    public GenrePojo updateGenre(GenrePojo genrePojo) {
        return GenrePojo.fromEntity(genreRepository.save(GenrePojo.toEntity(genrePojo)));
    }

    // TODO: return boolean
    public void deleteGenre(UUID id) {
        genreRepository.deleteById(id);
    }
}
