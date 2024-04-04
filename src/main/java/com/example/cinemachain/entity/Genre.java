package com.example.cinemachain.entity;

import com.example.cinemachain.entity.base.CommonEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "genre")
@AttributeOverride(name = "id", column = @Column(name = "genre_id"))
@SequenceGenerator(name = "default_id_seq", sequenceName = "genre_genre_id_seq", allocationSize = 1)
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Genre extends CommonEntity {
    @Column(name = "genre_name")
    private String name;
    @ManyToMany(mappedBy = "genres")
    private List<Film> films;

    public Genre(Long id) {
        this.setId(id);
    }
}
