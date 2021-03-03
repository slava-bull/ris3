package com.slava_bull.ris.common.mapper.impl;

import com.slava_bull.ris.common.mapper.Mapper;
import com.slava_bull.ris.model.AbstractEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public abstract class CommonMapper<Entity extends AbstractEntity, Dto> implements Mapper<Entity, Dto> {

    @Autowired
    protected ModelMapper mapper;

    private final Class<Entity> entityClass;
    private final Class<Dto> dtoClass;

    public CommonMapper(Class<Entity> entityClass, Class<Dto> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public Entity toEntity(Dto dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, entityClass);
    }

    @Override
    public Dto toDto(Entity entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, dtoClass);
    }

    protected Converter<Entity, Dto> toDtoConverter() {
        return context -> {
            Entity source = context.getSource();
            Dto destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    protected Converter<Dto, Entity> toEntityConverter() {
        return context -> {
            Dto source = context.getSource();
            Entity destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    protected void mapSpecificFields(Entity source, Dto destination) {
    }

    protected void mapSpecificFields(Dto source, Entity destination) {
    }
}
