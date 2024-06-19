package com.api.productor.entities;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"spot"})
@Entity(name = "uni_employees")
@Table(name = "uni_employee")
public class Employee {
//    unidirectional relationship
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String position;
    private String department;
    private Double salary;

    @OneToOne
    @JoinColumn(name = "spot_id", nullable = false)
    private ParkingSpot spot;

}
