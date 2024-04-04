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
@Table(name = "actor")
@AttributeOverride(name = "id", column = @Column(name = "actor_id"))
@SequenceGenerator(name = "default_id_seq", sequenceName = "actor_actor_id_seq", allocationSize = 1)
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Actor extends CommonEntity {
    @Column(name = "actor_first_name")
    String firstName; //Имя
    @Column(name = "actor_last_name")
    String lastName; //Фамилия
    @Column(name = "actor_second_name")
    String secondName; //Отчество
    @ManyToMany(mappedBy = "actors")
    List<Film> films;

    public Actor(Long id) {
        this.setId(id);
    }
}
