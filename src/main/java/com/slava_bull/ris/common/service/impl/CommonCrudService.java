package com.slava_bull.ris.common.service.impl;

import com.slava_bull.ris.common.service.CrudService;
import com.slava_bull.ris.exception.ContentNotFoundException;
import com.slava_bull.ris.model.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class CommonCrudService
        <Entity extends AbstractEntity, Repository extends JpaRepository<Entity, Long>>
        implements CrudService<Entity> {

    protected final Repository repository;

    @Override
    public Entity save(Entity item) {
        return repository.save(item);
    }

    @Override
    public Entity edit(Entity item) {
        Entity existingItem = getById(item.getId());
        return repository.save(existingItem);
    }

    @Override
    public List<Entity> findAll() {
        return repository.findAll();
    }

    @Override
    public Entity getById(long id) {
        return repository.findById(id).orElseThrow(ContentNotFoundException::new);
    }

    @Override
    public Optional<Entity> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}

