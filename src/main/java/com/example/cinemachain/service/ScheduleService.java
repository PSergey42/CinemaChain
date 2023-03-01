package com.example.cinemachain.service;

import com.example.cinemachain.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
}
