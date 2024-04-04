package com.example.cinemachain.entity.base;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PROTECTED)
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class CommonEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_id_seq")
    @Column(name = "id")
    Long id;

    LocalDateTime deletedAt;
}
