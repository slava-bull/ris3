package com.slava_bull.ris.common.mapper;

import com.slava_bull.ris.model.AbstractEntity;

public interface Mapper<E extends AbstractEntity, D> {
    E toEntity(D dto);

    D toDto(E entity);
}
