package com.example.cinemachain.controller;

import com.example.cinemachain.service.ActorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }
}
