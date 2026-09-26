package com.om.reseverticket.Service;

import com.om.reseverticket.DTO.StopRequestDTO;
import com.om.reseverticket.Entity.Routes;
import com.om.reseverticket.Entity.Stops;
import com.om.reseverticket.Repository.RouteRepo;
import com.om.reseverticket.Repository.StopsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StopsService {
    @Autowired
    private StopsRepo stopsRepo;
    @Autowired
    private RouteRepo routeRepo;

    @Transactional
    public boolean addStops(Long routeId,List<StopRequestDTO>stopDTOList){
        Routes route = routeRepo.findById(routeId).orElse(null);
        if (route == null || stopDTOList == null || stopDTOList.isEmpty()) {
            return false;
        }

        List<Stops> stopsToSave = new ArrayList<>();
        int order = 1;

        for (StopRequestDTO dto : stopDTOList) {
            Stops stop = new Stops();
            stop.setRoutes(route);
            stop.setStopName(dto.getStopName());
            stop.setStationCode(dto.getStationCode());
            stop.setDistanceKm(dto.getDistanceKm());
            stop.setStopOrder(order++);

            stopsToSave.add(stop);
        }

        stopsRepo.saveAll(stopsToSave);
        return true;

    }

}
