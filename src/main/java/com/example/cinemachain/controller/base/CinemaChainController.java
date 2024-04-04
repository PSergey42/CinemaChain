package com.example.cinemachain.controller.base;

import com.example.cinemachain.dto.base.CommonDTO;
import com.example.cinemachain.entity.base.CommonEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CinemaChainController <E extends CommonEntity, D extends CommonDTO> {
    @GetMapping(value = "/all")
    List<D> getAll();

    @GetMapping(value = "/{id}")
    D getById(@PathVariable Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity create(final @RequestBody D obj);

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity update(final @RequestBody D obj);

    @DeleteMapping(value = "/{ids}")
    ResponseEntity delete(@PathVariable List<Long> ids);

    @DeleteMapping(value = "/{id}")
    ResponseEntity delete(@PathVariable Long id);
}
