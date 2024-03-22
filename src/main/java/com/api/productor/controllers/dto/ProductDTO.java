package com.api.productor.controllers.dto;

import com.api.productor.entities.Maker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private Maker maker = new Maker();
}
