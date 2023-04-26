package com.example.cinemachain.service;


import com.example.cinemachain.entity.Actor;
import com.example.cinemachain.entity.Film;
import com.example.cinemachain.entity.Genre;
import com.example.cinemachain.entity.model.FilmPojo;
import com.example.cinemachain.repository.FilmRepository;
import com.example.cinemachain.util.Budget;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

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
        if (genresId != null && !genresId.equals("")){
            List<UUID> uuidGenres = Arrays.stream(genresId.split(",")).map(UUID::fromString).toList();
            list = list.stream().filter(x ->
                    uuidGenres.stream().allMatch(y ->
                            x.getGenres().stream().anyMatch(z -> z.getId().equals(y)))).toList();
        }
        if (actorsId != null && !actorsId.equals("")){
            List<UUID> uuidActors = Arrays.stream(actorsId.split(",")).map(UUID::fromString).toList();
            list = list.stream().filter(x ->
                    uuidActors.stream().allMatch(y ->
                            x.getActors().stream().anyMatch(z -> z.getId().equals(y)))).toList();
        }
        if(budgets != null && !budgets.equals("")){
            Budget budgets2 = Budget.parseBudget(budgets);
            list = list.stream().filter(x -> x.getBudget() <= budgets2.getUp() && x.getBudget() > budgets2.getDown()).toList();
        }
        return list;
    }

    public FilmPojo addActorInFilm(UUID filmId, UUID id) {
       Film film = filmRepository.findById(filmId).get();
       film.getActors().add(new Actor(id, null, null));
       return FilmPojo.fromEntity(filmRepository.save(film));
    }

    // TODO: return boolean
    public void deleteActorFromFilm(UUID filmId, UUID id) {
        Film film = filmRepository.findById(filmId).get();
        film.getActors().removeIf(actor -> id.equals(actor.getId()));
        filmRepository.save(film);
    }

    public FilmPojo addGenreInFilm(UUID filmId, UUID id) {
        Film film = filmRepository.findById(filmId).get();
        film.getGenres().add(new Genre(id, null, null));
        return FilmPojo.fromEntity(filmRepository.save(film));
    }

    // TODO: return boolean
    public void deleteGenreFromFilm(UUID filmId, UUID id) {
        Film film = filmRepository.findById(filmId).get();
        film.getGenres().removeIf(genre -> id.equals(genre.getId()));
        filmRepository.save(film);
    }
}
