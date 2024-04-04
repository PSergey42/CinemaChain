package com.example.cinemachain.controller;

import com.example.cinemachain.controller.base.BaseController;
import com.example.cinemachain.dto.ScheduleDTO;
import com.example.cinemachain.entity.Schedule;
import com.example.cinemachain.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController extends BaseController<Schedule, ScheduleDTO> {

    protected ScheduleController(ScheduleService service) {
        super(service);
    }

    @GetMapping("/search/date")
    public List<ScheduleDTO> getScheduleByCinemaIdAndDate(@RequestParam("id") Long id, @RequestParam(name = "date") String date){
        List<ScheduleDTO> list = ((ScheduleService) service).getScheduleByCinemaIdAndDate(id, date);
        if(list == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return list;
    }

    @GetMapping("/search")
    public List<ScheduleDTO> searchScheduleByName(@RequestParam(value = "nameSchedule", required = false) String nameSchedule,
                                                  @RequestParam(name = "date") String date,
                                                  @RequestParam(name = "cinemaId") Long cinemaId) {
        return ((ScheduleService) service).searchScheduleByName(cinemaId, nameSchedule, date);
    }
}
