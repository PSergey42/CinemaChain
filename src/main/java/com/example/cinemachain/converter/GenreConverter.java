package com.example.cinemachain.converter;

import com.example.cinemachain.converter.base.BaseConverter;
import com.example.cinemachain.dto.GenreDTO;
import com.example.cinemachain.entity.Genre;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GenreConverter implements BaseConverter<Genre, GenreDTO> {
    @Override
    public Genre toEntity(GenreDTO dto) {
        final Genre entity = new Genre();
        BeanUtils.copyProperties(entity, dto);
        return entity;
    }

    @Override
    public GenreDTO fromEntity(Genre entity) {
        final GenreDTO dto = new GenreDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
