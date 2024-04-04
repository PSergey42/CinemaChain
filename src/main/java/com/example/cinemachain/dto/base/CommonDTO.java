package com.example.cinemachain.dto.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PROTECTED)
public class CommonDTO {
    Long id;
}
