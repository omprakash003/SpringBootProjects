package com.om.reseverticket.Repository;

import com.om.reseverticket.Entity.Stops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopsRepo extends JpaRepository<Stops,Long> {
}
