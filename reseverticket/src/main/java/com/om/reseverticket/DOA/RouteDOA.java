package com.om.reseverticket.DOA;

import com.om.reseverticket.Entity.Routes;
import com.om.reseverticket.Entity.Trains;

import java.util.ArrayList;
import java.util.List;

public class RouteDOA {
    private  String SourceStation;
    private String DestinationStation;
    private List<String> trainInfo=new ArrayList<>();
    public RouteDOA(Routes route){
        this.SourceStation= route.getSource();
        this.DestinationStation=route.getDestination();
        List<Trains> trains= route.getTrains();
        for(Trains tr: trains){

            trainInfo.add(tr.getTrain_no() +" --- "+tr.getTrain_name()+" ---- "+ tr.getTrain_type());
        }
    }

    public String getSourceStation() {
        return SourceStation;
    }

    public void setSourceStation(String sourceStation) {
        SourceStation = sourceStation;
    }

    public String getDestinationStation() {
        return DestinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        DestinationStation = destinationStation;
    }

    public List<String> getTrainInfo() {
        return trainInfo;
    }

    public void setTrainInfo(List<String> trainInfo) {
        this.trainInfo = trainInfo;
    }
}
