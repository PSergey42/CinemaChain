package com.example.cinemachain.converter;

import com.example.cinemachain.converter.base.BaseConverter;
import com.example.cinemachain.dto.ScheduleDTO;
import com.example.cinemachain.dto.SessionDTO;
import com.example.cinemachain.entity.Schedule;
import com.example.cinemachain.entity.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduleConverter implements BaseConverter<Schedule, ScheduleDTO> {
    private final SessionConverter sessionConverter;


    @Override
    public Schedule toEntity(ScheduleDTO dto) {
        final Schedule entity = new Schedule();
        BeanUtils.copyProperties(entity, dto);

        List<SessionDTO> sessions = dto.getSessions();
        if (!sessions.isEmpty()) {
            entity.setSessions(sessions.stream().map(el -> new Session(el.getId())).toList());
        }

        return entity;
    }

    @Override
    public ScheduleDTO fromEntity(Schedule entity) {
        final ScheduleDTO dto = new ScheduleDTO();
        BeanUtils.copyProperties(entity, dto);

        List<Session> sessions = entity.getSessions();
        if (!sessions.isEmpty()) {
            dto.setSessions(sessions.stream().map(sessionConverter::fromEntity).toList());
        }

        return dto;
    }
}
