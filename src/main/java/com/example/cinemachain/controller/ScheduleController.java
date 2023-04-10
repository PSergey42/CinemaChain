package com.example.cinemachain.controller;

import com.example.cinemachain.entity.model.SchedulePojo;
import com.example.cinemachain.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedule")
    public List<SchedulePojo> getAll() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/schedule/{id}")
    public List<SchedulePojo> getScheduleByCinemaIdAndDate(@PathVariable("id") UUID id, @RequestParam(name = "date") String date){
        List<SchedulePojo> list = scheduleService.getScheduleByCinemaIdAndDate(id, date);
        if(list == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return list;
    }

    @PostMapping("/schedule")
    public SchedulePojo addSchedule(@RequestBody SchedulePojo schedulePojo){
        return scheduleService.addSchedule(schedulePojo);
    }

    @PutMapping("/schedule")
    public SchedulePojo updateSchedule(@RequestBody SchedulePojo schedulePojo){
        return scheduleService.updateSchedule(schedulePojo);
    }

    @DeleteMapping ("/schedule/{id}")
    public void deleteSchedule(@PathVariable("id") UUID id){
        scheduleService.deleteSchedule(id);
    }
}
