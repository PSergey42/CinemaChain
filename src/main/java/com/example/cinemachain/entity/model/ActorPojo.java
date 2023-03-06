package com.example.cinemachain.entity.model;

import com.example.cinemachain.entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ActorPojo {
    private UUID id;
    private String fio;

    public ActorPojo() {

    }

    public static Actor toEntity(ActorPojo actorPojo){
        return new Actor(actorPojo.getId(), actorPojo.getFio(), new ArrayList<>());
    }

    public static ActorPojo fromEntity(Actor actor){
        return new ActorPojo(actor.getId(), actor.getFio());
    }
}
