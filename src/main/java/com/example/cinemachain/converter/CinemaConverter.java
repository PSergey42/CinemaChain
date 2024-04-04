package com.example.cinemachain.converter;

import com.example.cinemachain.converter.base.BaseConverter;
import com.example.cinemachain.dto.CinemaDTO;
import com.example.cinemachain.entity.Cinema;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CinemaConverter implements BaseConverter<Cinema, CinemaDTO> {
    @Override
    public Cinema toEntity(CinemaDTO dto) {
        final Cinema entity = new Cinema();
        BeanUtils.copyProperties(entity, dto);
        return entity;
    }

    @Override
    public CinemaDTO fromEntity(Cinema entity) {
        final CinemaDTO dto = new CinemaDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
