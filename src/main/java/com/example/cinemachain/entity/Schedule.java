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
@Table(name = "schedule")
@AttributeOverride(name = "id", column = @Column(name = "schedule_id"))
@SequenceGenerator(name = "default_id_seq", sequenceName = "schedule_schedule_id_seq", allocationSize = 1)
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Schedule extends CommonEntity {
    @Column(name = "film_id")
    Long filmId;
    @Column(name = "cinema_id")
    Long cinemaId;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    List<Session> sessions;

    public Schedule(Long id) {
        this.setId(id);
    }
}
