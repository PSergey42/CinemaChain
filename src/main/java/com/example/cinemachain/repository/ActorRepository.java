package com.example.cinemachain.repository;


import com.example.cinemachain.entity.Actor;
import com.example.cinemachain.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends BaseRepository<Actor> {
    List<Actor> findAllByFirstNameContainingIgnoreCase(String name);
}
