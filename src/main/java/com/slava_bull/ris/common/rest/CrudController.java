package com.slava_bull.ris.common.rest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CrudController<Entity, SaveDto, EditDto> {

    @PostMapping
    Entity save(@RequestBody SaveDto item);

    @PutMapping
    Entity edit(@RequestBody EditDto item);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") long id);

    @GetMapping
    List<Entity> findAll();

    @GetMapping("/{id}")
    Entity getById(@PathVariable("id") long id);
}
