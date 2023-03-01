package com.example.cinemachain.repository;


import com.example.cinemachain.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ActorRepository extends JpaRepository<Actor, UUID> {
}
