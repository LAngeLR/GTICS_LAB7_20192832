package com.example.lab7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationID")
    private int locationId;

    @Column(name = "City")
    private String city;

    @Column(name = "Country")
    private String country;
}
