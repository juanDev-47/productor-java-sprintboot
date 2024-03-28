package com.api.productor.controllers.dto;

import com.api.productor.entities.Product;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Builder
public class MakerDTO {
    private long id;

    @NotNull(message = "The full name is required, can't be null")
    @NotBlank(message = "The full name can't be blank")
    private String fullName;

    @NotNull(message = "The country is required, can't be null")
    @NotBlank(message = "The country can't be blank")
    private String country;
    private String description;
    private List<Product> products = new ArrayList<>();

    // example of an email validation
    // @Email(message = "The email is not valid")
    // @NotBlank
    // @NotNull(message = "email can't be null")
    // private String email;
}
