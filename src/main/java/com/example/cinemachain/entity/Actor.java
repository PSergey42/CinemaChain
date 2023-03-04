package com.example.cinemachain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Table (name = "actor")
@Entity
public class Actor {
    @Id
    @Column(name = "actor_id")
    private UUID id;
    @Column(name = "fio")
    private String fio;
    @ManyToMany(mappedBy = "actors")
    private List<Film> films;
}
