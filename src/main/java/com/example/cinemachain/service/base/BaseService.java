package com.example.cinemachain.service.base;

import com.example.cinemachain.converter.base.BaseConverter;
import com.example.cinemachain.dto.base.CommonDTO;
import com.example.cinemachain.entity.base.CommonEntity;
import com.example.cinemachain.repository.base.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class BaseService<E extends CommonEntity, D extends CommonDTO> implements CinemaChainService<E, D> {

    protected final BaseRepository<E> repository;
    protected final BaseConverter<E, D> converter;
    @PersistenceContext
    protected EntityManager em;

    public BaseService(BaseRepository<E> repository, BaseConverter<E, D> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    @Transactional
    public D create(D obj) {
        final E entity = converter.toEntity(obj);
        E created = repository.saveAndFlush(entity);
        em.refresh(created);
        return converter.fromEntity(created);
    }

    @Override
    @Transactional
    public D update(D obj) {
        final E objToChange = repository.findById(obj.getId()).orElseThrow(() -> new EntityNotFoundException("Запись не найдена"));
        //а скопировать данные
        E updated = repository.saveAndFlush(objToChange);
        em.refresh(updated);
        return converter.fromEntity(updated);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteSoft(id, LocalDateTime.now());
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        repository.deleteSoft(ids, LocalDateTime.now());
    }

    @Override
    public List<D> getAll() {
        final List<E> all = repository.findAll();
        return all.stream().map(converter::fromEntity).toList();
    }

    @Override
    public D getById(Long id) {
        E obj = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Запись не найдена"));
        return converter.fromEntity(obj);
    }
}
