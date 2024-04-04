package com.example.cinemachain.dto;

import com.example.cinemachain.dto.base.CommonDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleDTO extends CommonDTO {
    UUID filmId;
    UUID cinemaId;
    List<SessionDTO> sessions;
}
