package com.api.productor.persistence.impl;

import com.api.productor.entities.Maker;
import com.api.productor.persistence.IMakerDAO;
import com.api.productor.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

    @Autowired
    private MakerRepository makerRepository;

    public Optional<Maker> findById(long id) {
        return makerRepository.findById(id);
    }

    public List<Maker> findAll() {
        return (List<Maker>) makerRepository.findAll();
    }

    public void save(Maker maker) {
        makerRepository.save(maker);
    }

    public void deleteById(long id) {
        makerRepository.deleteById(id);
    }
}
