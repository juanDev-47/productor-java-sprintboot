package com.api.productor.service;

import com.api.productor.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerService {
    Optional<Maker> findById(long id);
    List<Maker> findAll();
    void save(Maker maker);
    void deleteById(long id);
}
