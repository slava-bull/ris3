package com.slava_bull.ris.common.rest.impl;

import com.slava_bull.ris.common.mapper.Mapper;
import com.slava_bull.ris.common.rest.CrudController;
import com.slava_bull.ris.common.service.CrudService;
import com.slava_bull.ris.model.AbstractEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CommonCrudController<
        Entity extends AbstractEntity,
        SaveDto,
        SaveDtoMapper extends Mapper<Entity, SaveDto>,
        EditDto,
        EditDtoMapper extends Mapper<Entity, EditDto>,
        Service extends CrudService<Entity>>
        implements CrudController<Entity, SaveDto, EditDto> {

    private final Service service;
    protected final SaveDtoMapper saveMapper;
    protected final EditDtoMapper editMapper;

    @Override
    public Entity save(SaveDto item) {
        return service.save(saveMapper.toEntity(item));
    }

    @Override
    public Entity edit(EditDto item) {
        return service.edit(editMapper.toEntity(item));
    }

    @Override
    public void delete(long id) {
        service.delete(id);
    }

    @Override
    public List<Entity> findAll() {
        return service.findAll();
    }

    @Override
    public Entity getById(long id) {
        return service.getById(id);
    }
}
