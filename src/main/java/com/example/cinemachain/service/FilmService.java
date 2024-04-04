package com.example.cinemachain.service;


import com.example.cinemachain.converter.FilmConverter;
import com.example.cinemachain.dto.ActorDTO;
import com.example.cinemachain.dto.FilmDTO;
import com.example.cinemachain.dto.GenreDTO;
import com.example.cinemachain.entity.Film;
import com.example.cinemachain.repository.FilmRepository;
import com.example.cinemachain.service.base.BaseService;
import com.example.cinemachain.util.Budget;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FilmService extends BaseService<Film, FilmDTO> {

    public FilmService(FilmRepository repository, FilmConverter converter) {
        super(repository, converter);
    }

    public List<FilmDTO> searchFilmByName(String name) {
        return ((FilmRepository) repository).findAllByNameContainingIgnoreCase(name).stream().map(converter::fromEntity).toList();
    }

    public List<FilmDTO> getFilmsByParams(String nameFilm, String genresId, String actorsId, String budgets) {
        List<FilmDTO> list = searchFilmByName(nameFilm);
        if (genresId != null && !genresId.equals("")){
            List<Long> LongGenres = Arrays.stream(genresId.split(",")).map(Long::parseLong).toList();
            list = list.stream().filter(x ->
                    LongGenres.stream().allMatch(y ->
                            x.getGenres().stream().anyMatch(z -> z.getId().equals(y)))).toList();
        }
        if (actorsId != null && !actorsId.equals("")){
            List<Long> LongActors = Arrays.stream(actorsId.split(",")).map(Long::parseLong).toList();
            list = list.stream().filter(x ->
                    LongActors.stream().allMatch(y ->
                            x.getActors().stream().anyMatch(z -> z.getId().equals(y)))).toList();
        }
        if(budgets != null && !budgets.equals("")){
            Budget budgets2 = Budget.parseBudget(budgets);
            list = list.stream().filter(x -> x.getBudget() <= budgets2.getUp() && x.getBudget() > budgets2.getDown()).toList();
        }
        return list;
    }

    public FilmDTO addActorInFilm(Long filmId, Long id) {
        FilmDTO film = super.getById(filmId);
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setId(id);
        film.getActors().add(actorDTO);
        return super.update(film);
    }

    public void deleteActorFromFilm(Long filmId, Long id) {
        FilmDTO film = super.getById(filmId);
        film.getActors().removeIf(actor -> actor.getId().equals(id));
        super.update(film);
    }

    public FilmDTO addGenreInFilm(Long filmId, Long id) {
        FilmDTO film = super.getById(filmId);
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(id);
        film.getGenres().add(genreDTO);
        return super.update(film);
    }

    public void deleteGenreFromFilm(Long filmId, Long id) {
        FilmDTO film = super.getById(filmId);
        film.getGenres().removeIf(genre -> genre.getId().equals(id));
        super.update(film);
    }
}
