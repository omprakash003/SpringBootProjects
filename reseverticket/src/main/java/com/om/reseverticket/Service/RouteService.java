package com.om.reseverticket.Service;

import com.om.reseverticket.DOA.RouteDOA;
import com.om.reseverticket.Entity.Routes;
import com.om.reseverticket.Exceptions.RouteNotFoundException;
import com.om.reseverticket.Repository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepo routeRepo;

    public boolean AddRoute(Routes route){
        routeRepo.save(route);
        return true;
    }
    public Routes getRouteObj(Long Id){
        return routeRepo.findById(Id).orElseThrow(()-> new RouteNotFoundException(Id));

    }
    public RouteDOA getRoute(Long Id){
        Routes routes=routeRepo.findById(Id).orElseThrow(()-> new RouteNotFoundException(Id));
        return new RouteDOA(routes);
    }
    public boolean routeExists(Long Id)
    {
        return routeRepo.existsById(Id);
    }
}
