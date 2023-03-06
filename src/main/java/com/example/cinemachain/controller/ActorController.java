package com.example.cinemachain.controller;

import com.example.cinemachain.entity.model.ActorPojo;
import com.example.cinemachain.entity.model.FilmPojo;
import com.example.cinemachain.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ActorController {
    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public List<ActorPojo> getAll() {
        return actorService.getAllActors();
    }

    @GetMapping("/actor/{id}")
    public ActorPojo getActorById(@PathVariable("id") UUID id) {
        return actorService.getActorById(id);
    }

    @GetMapping("/actorByName/{nameActor}")
    public List<ActorPojo> searchActorByName(@PathVariable("nameActor") String nameActor) {
        return actorService.searchActorByName(nameActor);
    }

    @PutMapping("/actor")
    public ActorPojo addActor(@RequestBody ActorPojo actorPojo){
        return actorService.addActor(actorPojo);
    }

    @PostMapping("/actor")
    public ActorPojo updateActor(@RequestBody ActorPojo actorPojo){
        return actorService.updateActor(actorPojo);
    }

    @DeleteMapping ("/actor/{id}")
    public void deleteActor(@PathVariable("id") UUID id){
        actorService.deleteActor(id);
    }
}
