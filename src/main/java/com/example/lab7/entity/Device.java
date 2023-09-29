package com.example.lab7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeviceID")
    private int idDevice;

    @Column(name = "DeviceName")
    private String deviceName;

    @Column(name = "DeviceType")
    private String deviceType;

    @Column(name = "Model")
    private String deviceModel;

    @Column(name = "SerialNumber")
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site siteId;
}
