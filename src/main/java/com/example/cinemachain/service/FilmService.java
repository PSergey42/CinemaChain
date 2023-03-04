package com.example.cinemachain.service;


import com.example.cinemachain.entity.model.FilmPojo;
import com.example.cinemachain.repository.FilmRepository;
import com.example.cinemachain.util.Budget;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FilmService {
    private FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmPojo> getAllFilms() {
        return filmRepository.findAll().stream().map(FilmPojo::fromEntity).toList();
    }

    public List<FilmPojo> searchFilmByName(String nameFilm) {
        return filmRepository.findAllByNameContainingIgnoreCase(nameFilm).stream().map(FilmPojo::fromEntity).toList();
    }

    // TODO: return 404
    public FilmPojo getFilmById(UUID id) {
        var film = filmRepository.findById(id);
        if(film.isEmpty()){
            return null;
        }
        return FilmPojo.fromEntity(film.get());
    }

    public FilmPojo addFilm(FilmPojo filmPojo) {
        filmPojo.setId(UUID.randomUUID());
        return FilmPojo.fromEntity(filmRepository.save(FilmPojo.toEntity(filmPojo)));
    }

    public FilmPojo updateFilm(FilmPojo filmPojo) {
       return FilmPojo.fromEntity(filmRepository.save(FilmPojo.toEntity(filmPojo)));
    }

    // TODO: return boolean
    public void deleteFilm(UUID id) {
        filmRepository.deleteById(id);
    }

    public List<FilmPojo> getFilmsByParams(String nameFilm, String genresId, String actorsId, String budgets) {
        List<FilmPojo> list = searchFilmByName(nameFilm);
        if (!genresId.equals("")){
            List<UUID> uuidGenres = Arrays.stream(genresId.split(",")).map(UUID::fromString).toList();
            list = list.stream().filter(x -> x.getGenres().stream().anyMatch(y -> uuidGenres.stream().anyMatch(z -> z == y.getId()))).toList();
        }
        if (!actorsId.equals("")){
            List<UUID> uuidActors = Arrays.stream(actorsId.split(",")).map(UUID::fromString).toList();
            list = list.stream().filter(x -> x.getActors().stream().anyMatch(y -> uuidActors.stream().anyMatch(z -> z == y.getId()))).toList();
        }
        if(!budgets.equals("")){
            List<Budget> budgets2 = Arrays.stream(budgets.split(",")).map(Budget::parseBudget).toList();
            list = list.stream().filter(x -> budgets2.stream().anyMatch(z -> x.getBudget() <= z.getUp() && x.getBudget() > z.getDown())).toList();
        }
        return list;
    }
}
