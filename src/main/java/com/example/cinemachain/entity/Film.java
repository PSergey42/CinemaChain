package com.example.cinemachain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
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
    @JsonIgnore
    @ManyToMany()
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "genre_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;
    @JsonIgnore
    @ManyToMany()
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "actor_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;
    @Column(name = "budget")
    private long budget;

    public Film() {

    }

}
