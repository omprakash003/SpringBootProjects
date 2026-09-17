package com.om.reseverticket.Repository;

import com.om.reseverticket.Entity.Users;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String userName);
    Boolean existsByUsername(String userName);
    Boolean existsEmail(String email);
}
