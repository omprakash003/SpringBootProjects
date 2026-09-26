package com.om.reseverticket.Controller;

import com.om.reseverticket.DOA.TrainDOA;
import com.om.reseverticket.DTO.TrainSearchDTO;
import com.om.reseverticket.DTO.UpdateTrainDTO;
import com.om.reseverticket.Entity.Trains;
import com.om.reseverticket.Service.TrainService;
import com.om.reseverticket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    private TrainService trainService;
    @Autowired
    private UserService userService;
    @GetMapping("/all/{trainId}")
    public TrainDOA getTrains(@PathVariable Long trainId){
        return trainService.getTrain(trainId);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addTrains(@RequestBody Trains trains){
        if(trainService.existsById(trains.getTrain_no())){
            return new ResponseEntity<>("Train Number "+trains.getTrain_no()+" already exists",HttpStatus.CONFLICT);
        }
        trainService.saveTrain(trains);
        return new ResponseEntity<>(userService.getCurrentUserName()+" has added new train "+ trains.getTrain_name(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{trainId}")
    public ResponseEntity<String>deleteTrain(@PathVariable Long trainId){
        if(trainService.deleteById(trainId)){
            return new ResponseEntity<>("Train No "+ trainId+" deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Train No "+ trainId+" cannot be deleted",HttpStatus.OK);

    }
    @PutMapping("/update")
    public ResponseEntity<String> updateTrain(@RequestBody UpdateTrainDTO updateTrainDTO){
        if(updateTrainDTO.getTrainId()==null){
            return new ResponseEntity<>("Please provide train Id",HttpStatus.NOT_ACCEPTABLE);
        }
        if(trainService.update(updateTrainDTO)){
            return new ResponseEntity<>("Train updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Train updated failed",HttpStatus.BAD_REQUEST);


    }
    @GetMapping("/get/{trainType}")
    public ResponseEntity<List<String>> findByType(@PathVariable String trainType){
        return new ResponseEntity<>(trainService.getTrainByType(trainType),HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<List<TrainDOA>> searchTrains(@RequestBody TrainSearchDTO dto){
        List<TrainDOA> list=trainService.searchTrains(dto.getSource(), dto.getDestination());
        return new ResponseEntity<>(list,list.isEmpty()?HttpStatus.NOT_FOUND:HttpStatus.FOUND);
    }

}
