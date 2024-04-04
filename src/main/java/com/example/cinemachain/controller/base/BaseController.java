package com.example.cinemachain.controller.base;

import com.example.cinemachain.dto.base.CommonDTO;
import com.example.cinemachain.entity.base.CommonEntity;
import com.example.cinemachain.service.base.CinemaChainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BaseController <E extends CommonEntity, D extends CommonDTO> implements CinemaChainController<E, D> {
    protected final CinemaChainService<E, D> service;

    protected BaseController(CinemaChainService<E, D> service) {
        this.service = service;
    }

    @Override
    public List<D> getAll() {
        return service.getAll();
    }

    @Override
    public D getById(Long id) {
        return service.getById(id);
    }

    @Override
    public ResponseEntity<D> create(D obj) {
        D created = service.create(obj);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<D> update(D obj) {
        D updated = service.update(obj);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(List<Long> ids) {
        service.deleteByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
