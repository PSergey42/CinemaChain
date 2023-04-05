package com.example.cinemachain.service;

import com.example.cinemachain.entity.model.ActorPojo;
import com.example.cinemachain.entity.model.FilmPojo;
import com.example.cinemachain.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }


    public List<ActorPojo> getAllActors() {
        return actorRepository.findAll().stream().map(ActorPojo::fromEntity).toList();
    }

    // TODO: return 404
    public ActorPojo getActorById(UUID id) {
        var actor = actorRepository.findById(id);
        if(actor.isEmpty()){
            return null;
        }
        return ActorPojo.fromEntity(actor.get());
    }

    public List<ActorPojo> searchActorByName(String nameActor) {
        return actorRepository.findAllByFioContainingIgnoreCase(nameActor).stream().map(ActorPojo::fromEntity).toList();
    }

    public ActorPojo addActor(ActorPojo actorPojo) {
        actorPojo.setId(UUID.randomUUID());
        return ActorPojo.fromEntity(actorRepository.save(ActorPojo.toEntity(actorPojo)));
    }

    public ActorPojo updateActor(ActorPojo actorPojo) {
        return ActorPojo.fromEntity(actorRepository.save(ActorPojo.toEntity(actorPojo)));
    }

    // TODO: return boolean
    public void deleteActor(UUID id) {
        actorRepository.deleteById(id);
    }
}
