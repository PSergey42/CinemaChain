package com.example.cinemachain.controller;

import com.example.cinemachain.entity.model.GenrePojo;
import com.example.cinemachain.entity.model.SchedulePojo;
import com.example.cinemachain.entity.model.ScheduleV2Pojo;
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
    public List<ScheduleV2Pojo> getAll() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/schedule/{id}")
    public List<SchedulePojo> getScheduleByCinemaId(@PathVariable("id") UUID id) {
        return scheduleService.getScheduleByCinemaId(id);
    }

    @PutMapping("/schedule")
    public ScheduleV2Pojo addSchedule(@RequestBody ScheduleV2Pojo schedulePojo){
        return scheduleService.addSchedule(schedulePojo);
    }

    @PostMapping("/schedule")
    public ScheduleV2Pojo updateSchedule(@RequestBody ScheduleV2Pojo schedulePojo){
        return scheduleService.updateSchedule(schedulePojo);
    }

    @DeleteMapping ("/schedule/{id}")
    public void deleteSchedule(@PathVariable("id") UUID id){
        scheduleService.deleteSchedule(id);
    }
}
