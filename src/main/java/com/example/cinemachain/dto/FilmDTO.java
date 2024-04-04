package com.example.cinemachain.dto;

import com.example.cinemachain.dto.base.CommonDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmDTO extends CommonDTO {
    String name;
    LocalDate dateExits;
    List<GenreDTO> genres;
    List<ActorDTO> actors;
    Long budget;
}
