package com.om.reseverticket.Service;

import com.om.reseverticket.DOA.TrainDOA;
import com.om.reseverticket.Entity.Trains;
import com.om.reseverticket.Exceptions.TrainNotFoundException;
import com.om.reseverticket.Repository.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    @Autowired
    private TrainRepo trainRepo;

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


}
