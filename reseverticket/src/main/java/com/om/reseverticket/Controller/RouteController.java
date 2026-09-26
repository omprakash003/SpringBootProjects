package com.om.reseverticket.Controller;

import com.om.reseverticket.DOA.RouteDOA;
import com.om.reseverticket.Entity.Routes;
import com.om.reseverticket.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;
    @GetMapping("/get/{routeId}")
    public ResponseEntity<RouteDOA> getRoute(@PathVariable Long routeId) {
        return new ResponseEntity<>(routeService.getRoute(routeId),HttpStatus.OK);

    }
    @PostMapping("/add")
    public ResponseEntity<String> addRoute(@RequestBody  Routes route){
        routeService.AddRoute(route);
        return new ResponseEntity<>("Route has been added ", HttpStatus.OK);
    }
}
