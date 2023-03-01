package com.example.cinemachain.controller;

import com.example.cinemachain.service.ScheduleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {
    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
}
