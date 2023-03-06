package com.example.cinemachain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
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

    public Genre() {

    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\''  +
                '}';
    }
}
