package com.om.reseverticket.DOA;

import com.om.reseverticket.Entity.Trains;

public class TrainDOA {


    private Long trainNo;
    private String trainName;
    private String trainType;
    private Integer totalCoaches;
    public TrainDOA(Trains trains){
        this.trainNo=trains.getTrain_no();
        this.trainName=trains.getTrain_name();
        this.trainType=trains.getTrain_type();
        this.totalCoaches=trains.getTotal_coaches();
    }



    public Long getTrainNo() {
        return trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getTrainType() {
        return trainType;
    }

    public Integer getTotalCoaches() {
        return totalCoaches;
    }
}
