package com.example.cinemachain.converter;

import com.example.cinemachain.converter.base.BaseConverter;
import com.example.cinemachain.dto.SessionDTO;
import com.example.cinemachain.entity.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SessionConverter implements BaseConverter<Session, SessionDTO> {
    @Override
    public Session toEntity(SessionDTO dto) {
        final Session entity = new Session();
        BeanUtils.copyProperties(entity, dto);
        return entity;
    }

    @Override
    public SessionDTO fromEntity(Session entity) {
        final SessionDTO dto = new SessionDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
