package com.example.cinemachain.dto;

import com.example.cinemachain.dto.base.CommonDTO;
import com.example.cinemachain.entity.Cinema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CinemaDTO extends CommonDTO {
    String address;
    String name;
}
