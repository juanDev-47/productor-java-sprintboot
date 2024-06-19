package com.api.productor.controllers;

import com.api.productor.controllers.dto.ProductDTO;
import com.api.productor.entities.Product;
import com.api.productor.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Product product = productOptional.get();
        ProductDTO productDTO = ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
//                .maker(product.getMaker())
                .build();
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<ProductDTO> productDTOS = productService.findAll().stream().map(product -> ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
//                .maker(product.getMaker())
                .build()).toList();

        return ResponseEntity.ok(productDTOS);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid ProductDTO productDTO) throws URISyntaxException {
        if(productDTO.getName().isBlank() || productDTO.getPrice() == null || productDTO.getMaker() == null)
            return ResponseEntity.badRequest().build();

        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .category(productDTO.getCategory())
                .maker(productDTO.getMaker())
                .build();
        productService.save(product);
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ProductDTO productDTO) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
//            product.setMaker(productDTO.getMaker());
            productService.save(product);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
