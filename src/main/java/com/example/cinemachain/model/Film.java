package com.example.cinemachain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table (name = "film")
@Entity
public class Film {
    @Id
    @Column(name = "film_id")
    private UUID id;
    @Column(name = "film_name")
    private String name;
    @Column(name = "date_exits")
    private Date dateExits;
    @ManyToMany
    @JoinTable(
            name = "genre_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;
    @ManyToMany
    @JoinTable(
            name = "actor_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;
    @Column(name = "budget")
    private long budget;
}
