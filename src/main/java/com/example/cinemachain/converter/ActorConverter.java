package com.example.cinemachain.converter;

import com.example.cinemachain.converter.base.BaseConverter;
import com.example.cinemachain.dto.ActorDTO;
import com.example.cinemachain.entity.Actor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ActorConverter implements BaseConverter<Actor, ActorDTO> {
    @Override
    public Actor toEntity(ActorDTO dto) {
        final Actor entity = new Actor();
        BeanUtils.copyProperties(entity, dto);
        return entity;
    }

    @Override
    public ActorDTO fromEntity(Actor entity) {
        final ActorDTO dto = new ActorDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
