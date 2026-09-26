package com.om.reseverticket.Exceptions;

public class RouteNotFoundException extends RuntimeException{
    public RouteNotFoundException(Long Id){
        super("There is no route with the Id " + Id);
    }
}
