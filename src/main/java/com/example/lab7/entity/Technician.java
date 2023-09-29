package com.example.lab7.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "technician")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID")
    private int technicianId;

    @Size(max = 300, min=3, message = "Solo se soportan entre 3-300 caracteres")
    @NotBlank
    @Column(name = "FirstName")
    private String firstName;

    @Size(max = 300, min=3, message = "Solo se soportan entre 3-300 caracteres")
    @NotBlank
    @Column(name = "LastName")
    private String lastName;

    @Size(max = 8, message = "Solo se soportan 8 digitos")
    @NotBlank
    @Column(name = "Dni")
    private String dni;

    @Size(max = 9, message = "Solo se soportan 9 digitos")
    @NotBlank
    @Column(name = "Phone")
    private String phone;

    @NotBlank
    @Positive
    @Column(name = "Age")
    private int age;

}
