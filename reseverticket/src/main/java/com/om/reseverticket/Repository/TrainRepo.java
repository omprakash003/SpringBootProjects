package com.om.reseverticket.Repository;

import com.om.reseverticket.Entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepo extends JpaRepository<Trains,Long> {
    @Query("SELECT t from Trains t WHERE" +
            " LOWER(t.train_type) LIKE LOWER( CONCAT('%', :trainType, '%' ))")
    List<Trains> findByTrainTypeLike(String trainType);

}
