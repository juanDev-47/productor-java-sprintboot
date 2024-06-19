package com.api.productor.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"spot"})
@Entity(name = "uni_parking_spots")
@Table(name = "uni_parking_spots")

public class ParkingSpot {
//    unidirectional relationship
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String spotName;
    private String spotType;

//    bidirectional relationship
//    @OneToOne(mappedBy = "spot")
//    private Employee employee;


}
