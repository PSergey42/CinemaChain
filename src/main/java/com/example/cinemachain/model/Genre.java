package com.example.cinemachain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Table (name = "genre")
@Entity
public class Genre {
    @Id
    @Column(name = "genre_id")
    private UUID id;
    @Column(name = "genre_name")
    private String name;
    @ManyToMany(mappedBy = "genres")
    private List<Film> films;
}
