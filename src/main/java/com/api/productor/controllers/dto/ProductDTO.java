package com.api.productor.controllers.dto;

import com.api.productor.entities.Maker;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Builder
public class ProductDTO {
    private long id;
    @NotNull(message = "The name is required")
    private String name;

    private String description;
    @NotNull(message = "The price is required")
    @Digits(integer = 10, fraction = 2, message = "The price is not valid")
    private BigDecimal price;
    @NotNull(message = "The category is required")
    private String category;
    private Maker maker = new Maker();

    // example of an date
    // @Past(message = "The date must be before the current date")
    // private LocalDate dateOfBirth;
}
