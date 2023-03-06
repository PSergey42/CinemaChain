package com.example.cinemachain.entity.model;

import com.example.cinemachain.entity.Actor;
import com.example.cinemachain.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@Data
@AllArgsConstructor
public class GenrePojo {
    private UUID id;
    private String name;

    public GenrePojo() {

    }

    public static Genre toEntity(GenrePojo genrePojo){
        return new Genre(genrePojo.getId(), genrePojo.getName(), new ArrayList<>());
    }

    public static GenrePojo fromEntity(Genre genre){
        return new GenrePojo(genre.getId(), genre.getName());
    }
}
