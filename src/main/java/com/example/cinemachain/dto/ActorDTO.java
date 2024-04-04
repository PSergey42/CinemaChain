package com.example.cinemachain.dto;

import com.example.cinemachain.dto.base.CommonDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActorDTO extends CommonDTO {
    String firstName; //Имя
    String lastName; //Фамилия
    String secondName; //Отчество
}
