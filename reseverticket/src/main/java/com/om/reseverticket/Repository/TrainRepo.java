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
    @Query("SELECT DISTINCT t FROM Trains t " +
            "JOIN t.route r " +
            "JOIN r.stops s_from " +
            "JOIN r.stops s_to " +
            "WHERE LOWER(s_from.stopName) LIKE LOWER(CONCAT('%', :source, '%')) " +
            "  AND LOWER(s_to.stopName) LIKE LOWER(CONCAT('%', :destination, '%')) " +
            "  AND s_from.stopOrder < s_to.stopOrder")
    List<Trains> findTrains(String source , String destination);



}
