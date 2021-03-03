package com.slava_bull.ris.common.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<Entity> {
    Entity save(Entity item);

    Entity edit(Entity item);

    List<Entity> findAll();

    Entity getById(long id);

    Optional<Entity> findById(long id);

    void delete(long id);
}
