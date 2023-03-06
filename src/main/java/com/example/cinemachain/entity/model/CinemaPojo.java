package com.example.cinemachain.entity.model;

import com.example.cinemachain.entity.Cinema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CinemaPojo {
    private UUID id;
    private String address;
    private String name;

    public CinemaPojo() {

    }

    public static Cinema toEntity(CinemaPojo cinemaPojo){
        return new Cinema(cinemaPojo.getId(), cinemaPojo.getAddress(), cinemaPojo.getName());
    }

    public static CinemaPojo fromEntity(Cinema cinema){
        return new CinemaPojo(cinema.getId(), cinema.getAddress(), cinema.getName());
    }
}
