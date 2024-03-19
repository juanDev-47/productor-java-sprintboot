package com.api.productor.persistence;

import com.api.productor.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {

    Optional<Maker> findById(long id);
    List<Maker> findAll();
    void save(Maker maker);
    void deleteById(long id);
}
