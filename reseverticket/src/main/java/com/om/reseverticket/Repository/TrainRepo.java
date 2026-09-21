package com.om.reseverticket.Repository;

import com.om.reseverticket.Entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends JpaRepository<Trains,Long> {

}
