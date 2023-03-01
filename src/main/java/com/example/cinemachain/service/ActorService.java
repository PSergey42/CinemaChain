package com.example.cinemachain.service;

import com.example.cinemachain.repository.ActorRepository;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    private ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
}
