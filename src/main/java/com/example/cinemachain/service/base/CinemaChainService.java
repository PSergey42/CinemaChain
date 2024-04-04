package com.example.cinemachain.service.base;

import com.example.cinemachain.dto.base.CommonDTO;
import com.example.cinemachain.entity.base.CommonEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CinemaChainService <E extends CommonEntity, D extends CommonDTO> {
    @Transactional
    D create(D obj);
    @Transactional
    void deleteById(final Long id);
    void deleteByIds(final List<Long> ids);
    List<D> getAll();
    D getById(final Long id);
    @Transactional
    D update(D obj);
}
