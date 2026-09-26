package com.om.reseverticket.DTO;

public class StopRequestDTO {
    private String stopName;
    private String stationCode;
    private Long distanceKm;

    public StopRequestDTO() {}

    public String getStopName() { return stopName; }
    public void setStopName(String stopName) { this.stopName = stopName; }

    public String getStationCode() { return stationCode; }
    public void setStationCode(String stationCode) { this.stationCode = stationCode; }

    public Long getDistanceKm() { return distanceKm; }
    public void setDistanceKm(Long distanceKm) { this.distanceKm = distanceKm; }
}
