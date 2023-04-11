package com.example.cinemachain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Table (name = "schedule")
@Entity
public class Schedule {
    @Id
    @Column(name = "schedule_id")
    private UUID id;
    @Column(name = "film_id")
    //@JoinColumn(name = "schedule_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private UUID filmId;
    @Column(name = "cinema_id")
    private UUID cinemaId;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Session> sessions;

    public Schedule() {

    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", filmId=" + filmId +
                ", cinemaId=" + cinemaId +
                ", sessions=" + sessions +
                '}';
    }
}
