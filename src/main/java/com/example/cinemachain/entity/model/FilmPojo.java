package com.example.cinemachain.entity.model;

import com.example.cinemachain.entity.Actor;
import com.example.cinemachain.entity.Film;
import com.example.cinemachain.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class FilmPojo {
    private UUID id;
    private String name;
    private Date dateExits;
    private List<GenrePojo> genres;
    private List<ActorPojo> actors;
    private long budget;

    public FilmPojo() {

    }

    public static Film toEntity(FilmPojo filmPojo){
        return new Film(filmPojo.getId(), filmPojo.getName(), filmPojo.getDateExits(), filmPojo.getGenres().stream().map(GenrePojo::toEntity).toList(),
                filmPojo.getActors().stream().map(ActorPojo::toEntity).toList(), filmPojo.getBudget());
    }

    public static FilmPojo fromEntity(Film film){
        return new FilmPojo(film.getId(), film.getName(), film.getDateExits(), film.getGenres().stream().map(GenrePojo::fromEntity).toList(),
                film.getActors().stream().map(ActorPojo::fromEntity).toList(), film.getBudget());
    }
}
