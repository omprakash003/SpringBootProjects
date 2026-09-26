package com.om.reseverticket.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "SMPO_ROUTES")
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_seq_gen")
    @SequenceGenerator(name = "route_seq_gen", sequenceName = "ROUTE_SEQ", allocationSize = 1)
    @Column(name = "ROUTE_ID")
    
    private Long routeId;
    @Column(name="SOURCE_STATION",nullable = false)
    private String source;
    @Column(name="DESTINATION_STATION",nullable = false)
    private String destination;
    @Column(name = "CREATED_ON",nullable = false,insertable = false,updatable = false)
    private LocalDateTime createdOn;
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Trains> trains;
    @OneToMany(mappedBy = "routes",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference

    private List<Stops> stops;


    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;

    }

    public List<Trains> getTrains() {
        return trains;
    }

    public void setTrains(List<Trains> trains) {
        this.trains = trains;
    }
}
