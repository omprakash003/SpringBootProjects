package com.om.reseverticket.Controller;

import com.om.reseverticket.DTO.StopRequestDTO;
import com.om.reseverticket.Service.StopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stops")
public class StopController {
    @Autowired
    private StopsService stopsService;
    @PostMapping("/add/{routeId}")
    public ResponseEntity<String> addStops(@PathVariable Long routeId, @RequestBody  List<StopRequestDTO>stops){
        if(stopsService.addStops(routeId,stops)){
            return new ResponseEntity<>("The Stops have been added", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("some error adding",HttpStatus.BAD_REQUEST);

    }

}
