package com.api.productor.controllers;

import com.api.productor.controllers.dto.MakerDTO;
import com.api.productor.entities.Maker;
import com.api.productor.service.IMakerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
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
    public ResponseEntity<?> getAll() {
        List<MakerDTO> makerDTOS = makerService.findAll().stream().map(maker -> MakerDTO.builder()
                .id(maker.getId())
                .fullName(maker.getFullName())
                .country(maker.getCountry())
                .description(maker.getDescription())
//                .products(maker.getProducts())
                .build()).toList();

        return ResponseEntity.ok(makerDTOS);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid MakerDTO makerDTO) throws URISyntaxException {
        if(makerDTO.getFullName().isBlank() || makerDTO.getCountry().isBlank())
            return ResponseEntity.badRequest().build();

        Maker maker = Maker.builder()
                .fullName(makerDTO.getFullName())
                .country(makerDTO.getCountry())
                .description(makerDTO.getDescription())
                .build();
        makerService.save(maker);
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid MakerDTO makerDTO) {
        Optional<Maker> makerOptional = makerService.findById(id);
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setFullName(makerDTO.getFullName());
            maker.setCountry(makerDTO.getCountry());
            maker.setDescription(makerDTO.getDescription());
            makerService.save(maker);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findById(id);
        if (makerOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        makerService.deleteById(id);
        return ResponseEntity.ok("Registro Eliminado");
    }

}
