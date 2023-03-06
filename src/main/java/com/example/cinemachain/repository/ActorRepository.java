package com.example.cinemachain.repository;


import com.example.cinemachain.entity.Actor;
import com.example.cinemachain.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface ActorRepository extends JpaRepository<Actor, UUID> {
    List<Actor> findAllByFioContainingIgnoreCase(String nameActor);
}
