package com.example.cinemachain.entity;

import com.example.cinemachain.entity.base.CommonEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "session")
@AttributeOverride(name = "id", column = @Column(name = "session_id"))
@SequenceGenerator(name = "default_id_seq", sequenceName = "session_session_id_seq", allocationSize = 1)
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Session extends CommonEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    Schedule schedule;
    @Column(name = "session_show_date")
    LocalDate showDate;
    @Column(name = "session_show_time")
    Time showTime;
    @Column(name = "session_hall")
    Long hall;
    @Column(name = "session_number_seats")
    Long numberSeats;

    public Session(Long id) {
        this.setId(id);
    }
}
