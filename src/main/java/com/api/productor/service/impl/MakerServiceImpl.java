package com.api.productor.service.impl;

import com.api.productor.entities.Maker;
import com.api.productor.persistence.IMakerDAO;
import com.api.productor.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements IMakerService {

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public Optional<Maker> findById(long id) {
        return makerDAO.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return makerDAO.findAll();
    }

    @Override
    public void save(Maker maker) {
        makerDAO.save(maker);
    }

    @Override
    public void deleteById(long id) {
        makerDAO.deleteById(id);
    }
}
