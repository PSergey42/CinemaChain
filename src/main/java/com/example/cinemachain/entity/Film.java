package com.example.cinemachain.entity;

import com.example.cinemachain.entity.base.CommonEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "film")
@AttributeOverride(name = "id", column = @Column(name = "film_id"))
@SequenceGenerator(name = "default_id_seq", sequenceName = "film_film_id_seq", allocationSize = 1)
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film extends CommonEntity {
    @Column(name = "film_name")
    String name;
    @Column(name = "film_date_exits")
    LocalDate dateExits;
    @JsonIgnore
    @ManyToMany()
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "genre_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    List<Genre> genres;
    @JsonIgnore
    @ManyToMany()
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "actor_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    List<Actor> actors;
    @Column(name = "film_budget")
    Long budget;

    public Film(Long id) {
        this.setId(id);
    }
}
