package com.om.reseverticket.DTO;

public class UpdateTrainDTO {
    private Long trainId;
    private String trainName;
    private String trainType;
    private Integer coaches;

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public void setCoaches(Integer coaches) {
        this.coaches = coaches;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getTrainType() {
        return trainType;
    }

    public Integer getCoaches() {
        return coaches;
    }
}
