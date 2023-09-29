package com.example.lab7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Entity
@Getter
@Setter
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID")
    private int ticketId;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site siteId;

    @ManyToOne
    @JoinColumn(name = "TechnicianID")
    private Technician TechnicianId;

    @Column(name = "Status")
    private String status;

    @Column(name = "OpenedDate")
    private Timestamp OpenedDate;

    @Column(name = "ClosedDate")
    private Timestamp closedDate;
}
