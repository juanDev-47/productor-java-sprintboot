package com.api.productor.controllers;

import com.api.productor.controllers.dto.MakerDTO;
import com.api.productor.entities.Maker;
import com.api.productor.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {

    @Autowired
    private IMakerService makerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findById(id);
        if (makerOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Maker maker = makerOptional.get();
        MakerDTO makerDTO = MakerDTO.builder()
                .id(maker.getId())
                .fullName(maker.getFullName())
                .country(maker.getCountry())
                .description(maker.getDescription())
                .products(maker.getProducts())
                .build();
        return ResponseEntity.ok(makerDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Maker>> getAll() {
        return ResponseEntity.ok(makerService.findAll());
    }

}
