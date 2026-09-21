package com.om.reseverticket.Service;

import com.om.reseverticket.Entity.Trains;
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

}
