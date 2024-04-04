package com.example.cinemachain.controller;

import com.example.cinemachain.controller.base.BaseController;
import com.example.cinemachain.dto.ActorDTO;
import com.example.cinemachain.entity.Actor;
import com.example.cinemachain.service.ActorService;
import com.example.cinemachain.service.base.CinemaChainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/actor")
public class ActorController extends BaseController<Actor, ActorDTO> {
    protected ActorController(ActorService service) {
        super(service);
    }

    @GetMapping("/search/{name}")
    public List<ActorDTO> searchActorByName(@PathVariable("name") String nameActor) {
        return ((ActorService) service).searchByName(nameActor);
    }
}
