package com.api.productor.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;

//    bidirectional relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maker_id")
    @JsonIgnore
    private Maker maker;
}
