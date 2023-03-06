package com.example.cinemachain.controller;

import com.example.cinemachain.entity.model.GenrePojo;
import com.example.cinemachain.entity.model.SchedulePojo;
import com.example.cinemachain.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ScheduleController {
    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedules")
    public List<SchedulePojo> getAll() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/schedule/{id}")
    public SchedulePojo getScheduleById(@PathVariable("id") UUID id) {
        return scheduleService.getScheduleById(id);
    }

    @PutMapping("/schedule")
    public SchedulePojo addSchedule(@RequestBody SchedulePojo schedulePojo){
        return scheduleService.addSchedule(schedulePojo);
    }

    @PostMapping("/schedule")
    public SchedulePojo updateSchedule(@RequestBody SchedulePojo schedulePojo){
        return scheduleService.updateSchedule(schedulePojo);
    }

    @DeleteMapping ("/schedule/{id}")
    public void deleteSchedule(@PathVariable("id") UUID id){
        scheduleService.deleteSchedule(id);
    }
}
