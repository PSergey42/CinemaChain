package com.example.cinemachain.entity;

import com.example.cinemachain.entity.base.CommonEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "cinema")
@AttributeOverride(name = "id", column = @Column(name = "cinema_id"))
@SequenceGenerator(name = "default_id_seq", sequenceName = "cinema_cinema_id_seq", allocationSize = 1)
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cinema extends CommonEntity {
    @Column(name = "cinema_address")
    String address;
    @Column(name = "cinema_name")
    String name;

    public Cinema(Long id) {
        this.setId(id);
    }
}
