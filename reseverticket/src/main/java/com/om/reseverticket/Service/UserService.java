package com.om.reseverticket.Service;

import com.om.reseverticket.Entity.Users;
import com.om.reseverticket.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Transactional
    public boolean SaveUser(Users user){
        if (userRepo.existsByUserName(user.getUserName()) || userRepo.existsByEmail(user.getEmail())) {
            return false;
        }
        userRepo.save(user);
        return true;

    }
    public Optional<Users> getByUserName(String userName){
        return userRepo.findByUserName(userName);

    }
    public Optional<Users> getById(Long userId){
        return userRepo.findById(userId);
    }
    @Transactional
    public boolean deactivateUser(Long userId) {
        return userRepo.findById(userId).map(user -> {
            user.setIsActive('N');
            userRepo.save(user);
            return true;
        }).orElse(false);
    }
    @Transactional
    public boolean deactivateUser(String userName) {
        return userRepo.findByUserName(userName).map(user ->{
            user.setIsActive('N');
            userRepo.save(user);
            return true;
        }).orElse(false);
    }
}
