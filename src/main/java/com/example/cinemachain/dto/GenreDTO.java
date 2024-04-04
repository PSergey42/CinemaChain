package com.example.cinemachain.dto;

import com.example.cinemachain.dto.base.CommonDTO;
import com.example.cinemachain.entity.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenreDTO extends CommonDTO {
    String name;
}
