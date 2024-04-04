package com.example.cinemachain.converter;

import com.example.cinemachain.converter.base.BaseConverter;
import com.example.cinemachain.dto.ActorDTO;
import com.example.cinemachain.dto.FilmDTO;
import com.example.cinemachain.dto.GenreDTO;
import com.example.cinemachain.entity.Actor;
import com.example.cinemachain.entity.Film;
import com.example.cinemachain.entity.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FilmConverter implements BaseConverter<Film, FilmDTO> {

    private final ActorConverter actorConverter;
    private final GenreConverter genreConverter;

    @Override
    public Film toEntity(FilmDTO dto) {
        final Film entity = new Film();
        BeanUtils.copyProperties(entity, dto);

        List<ActorDTO> actors = dto.getActors();
        if (!actors.isEmpty()) {
            entity.setActors(actors.stream().map(el -> new Actor(el.getId())).toList());
        }

        List<GenreDTO> genres = dto.getGenres();
        if (!genres.isEmpty()) {
            entity.setGenres(genres.stream().map(el -> new Genre(el.getId())).toList());
        }

        return entity;
    }

    @Override
    public FilmDTO fromEntity(Film entity) {
        final FilmDTO dto = new FilmDTO();
        BeanUtils.copyProperties(entity, dto);

        List<Actor> actors = entity.getActors();
        if (!actors.isEmpty()) {
            dto.setActors(actors.stream().map(actorConverter::fromEntity).toList());
        }

        List<Genre> genres = entity.getGenres();
        if (!genres.isEmpty()) {
            dto.setGenres(genres.stream().map(genreConverter::fromEntity).toList());
        }

        return dto;
    }
}

