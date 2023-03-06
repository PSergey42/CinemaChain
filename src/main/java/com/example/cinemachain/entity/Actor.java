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
@Table (name = "actor")
@Entity
@AllArgsConstructor
public class Actor {
    @Id
    @Column(name = "actor_id")
    private UUID id;
    @Column(name = "fio")
    private String fio;
    @ManyToMany(mappedBy = "actors")
    private List<Film> films;

    public Actor() {

    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                '}';
    }
}
