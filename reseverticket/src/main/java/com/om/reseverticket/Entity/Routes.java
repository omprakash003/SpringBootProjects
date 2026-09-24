package com.om.reseverticket.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "SMPO_ROUTES")
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_seq_gen")
    @SequenceGenerator(name = "route_seq_gen", sequenceName = "ROUTE_SEQ", allocationSize = 1)
    @Column(name = "ROUTE_ID")
    
    private Long routeId;
    @Column(name="SOURCE_STATION",nullable = false)
    private String Source;
    @Column(name="DESTINATION_STATION",nullable = false)
    private String Destination;
    @Column(name = "CREATED_ON",nullable = false,insertable = false,updatable = false)
    private LocalDateTime createdOn;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
