package com.om.reseverticket.Repository;

import com.om.reseverticket.Entity.Users;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Optional<Users> findByUserName(String userName);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM SMPO_USERS WHERE USER_NAME = :userName", nativeQuery = true)
    Integer checkExistsByUserName(@Param("userName") String userName);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM SMPO_USERS WHERE EMAIL = :email", nativeQuery = true)
    Integer checkExistsByEmail(@Param("email") String email);

    default boolean existsByUserName(String userName) {
        return Integer.valueOf(1).equals(checkExistsByUserName(userName));
    }

    default boolean existsByEmail(String email) {
        return Integer.valueOf(1).equals(checkExistsByEmail(email));
    }
}
