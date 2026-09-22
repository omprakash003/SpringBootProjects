package com.om.reseverticket.Exceptions;

public class TrainNotFoundException extends RuntimeException{
    public TrainNotFoundException(Long Id){
        super("No train with Train Number "+Id +"  please check the number");
    }
}
