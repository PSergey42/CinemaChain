package com.example.cinemachain.service;

import com.example.cinemachain.converter.ActorConverter;
import com.example.cinemachain.dto.ActorDTO;
import com.example.cinemachain.entity.Actor;
import com.example.cinemachain.repository.ActorRepository;
import com.example.cinemachain.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService extends BaseService<Actor, ActorDTO> {

    public ActorService(ActorRepository repository, ActorConverter converter) {
        super(repository, converter);
    }

    public List<ActorDTO> searchByName(String name) {
        return ((ActorRepository) repository).findAllByFirstNameContainingIgnoreCase(name).stream().map(converter::fromEntity).toList();
    }
}
