package com.example.cinemachain.converter.base;

import com.example.cinemachain.dto.base.CommonDTO;
import com.example.cinemachain.entity.base.CommonEntity;

public interface BaseConverter <E extends CommonEntity, D extends CommonDTO> {
    E toEntity(D dto);
    D fromEntity(E entity);
}
