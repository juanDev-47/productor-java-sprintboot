package com.api.productor.controllers.dto;

import com.api.productor.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {
    private long id;
    private String fullName;
    private String country;
    private String description;
    private List<Product> products = new ArrayList<>();
}
