package com.example.lab7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID")
    private int siteId;

    @Column(name = "SiteName")
    private String siteName;

    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location locationId;

    @Column(name = "InstallationDate")
    private String installationDate;

    @Column(name = "Latitude")
    private String latitude;

    @JoinColumn(name = "Longitude")
    private String longitude;


}
