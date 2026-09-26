package com.om.reseverticket.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "SMPO_STOPS")
public class Stops {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stop_gen")
    @SequenceGenerator(name = "stop_gen",sequenceName = "STOP_SEQUENCE",allocationSize = 1)
    @Column(name = "STOP_ID")
    private Long stopId;
    @ManyToOne
    @JoinColumn(name = "ROUTE_ID")
    @JsonBackReference
    private Routes routes;
    @Column(name = "STOP_NAME")

    private String stopName;
    @Column(name = "STATION_CODE")
    private String stationCode;
    @Column(name = "STOP_ORDER")
    private Integer stopOrder;
    @Column(name="DISTANCE_KM")
    private Long distanceKm;

    public Long getStopId() {
        return stopId;
    }

    public void setStopId(Long stopId) {
        this.stopId = stopId;
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public Integer getStopOrder() {
        return stopOrder;
    }

    public void setStopOrder(Integer stopOrder) {
        this.stopOrder = stopOrder;
    }

    public Long getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Long distanceKm) {
        this.distanceKm = distanceKm;
    }
}
