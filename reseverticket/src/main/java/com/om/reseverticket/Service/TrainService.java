package com.om.reseverticket.Service;

import com.om.reseverticket.DOA.TrainDOA;
import com.om.reseverticket.DTO.UpdateTrainDTO;
import com.om.reseverticket.Entity.Trains;
import com.om.reseverticket.Exceptions.TrainNotFoundException;
import com.om.reseverticket.Repository.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainRepo trainRepo;
    @Autowired
    private RouteService routeService;

    public boolean AddTrain(Trains train){
        trainRepo.save(train);
        return true;
    }
    public TrainDOA getTrain(Long trainId){
        Trains train =trainRepo.findById(trainId).orElseThrow(()->new TrainNotFoundException(trainId));
        return new TrainDOA(train);
    }
    public boolean saveTrain(Trains trains){
        trainRepo.save(trains);
        return true;
    }
    public boolean existsById(Long trainId){
        return trainRepo.existsById(trainId);
    }
    public boolean deleteById(Long trainId){
        trainRepo.deleteById(trainId);
        return true;
    }
    public boolean update(UpdateTrainDTO updateTrainDTO){
        Trains trains=trainRepo.findById(updateTrainDTO
                        .getTrainId())
                .orElseThrow(()->new TrainNotFoundException(updateTrainDTO.getTrainId()));
        if(updateTrainDTO.getTrainName()!=null){
            trains.setTrain_name(updateTrainDTO.getTrainName());
        }
        if(updateTrainDTO.getCoaches()!=null){
            trains.setTotal_coaches(updateTrainDTO.getCoaches());
        }
        if(updateTrainDTO.getTrainType()!=null){
            trains.setTrain_type(updateTrainDTO.getTrainType());
        }
        if(updateTrainDTO.getRouteId()!=null){
            if(routeService.routeExists(updateTrainDTO.getRouteId())){
                trains.setRoute_id(routeService.getRouteObj(updateTrainDTO.getRouteId()));
            }

        }
        trainRepo.save(trains);
        return true;
    }
    public List<String> getTrainByType(String type){
        List<Trains> trains=trainRepo.findByTrainTypeLike(type);
        List<String > trainNames=new ArrayList<>();
        for(Trains t :trains){
            trainNames.add(t.getTrain_no()+" "+t.getTrain_name());
        }
        return trainNames;
    }
    public List<TrainDOA> searchTrains(String source, String destination){
        List<TrainDOA> list=new ArrayList<>();
        List<Trains> trains=trainRepo.findTrains(source,destination);
        for(Trains tr: trains){
            TrainDOA doa=new TrainDOA(tr);
            list.add(doa);
        }
        return list;
    }


}
