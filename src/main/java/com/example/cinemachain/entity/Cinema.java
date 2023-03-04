package com.example.cinemachain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Table (name = "cinema")
@Entity
public class Cinema {
    @Id
    @Column(name = "cinema_id")
    private UUID id;
    @Column(name = "address")
    private String address;
    @Column(name = "cinema_name")
    private String name;
}
