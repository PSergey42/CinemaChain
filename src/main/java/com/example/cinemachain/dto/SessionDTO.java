package com.example.cinemachain.dto;

import com.example.cinemachain.dto.base.CommonDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SessionDTO extends CommonDTO {
    LocalDate showDate;
    String showTime;
    Integer hall;
    Integer numberSeats;
}
