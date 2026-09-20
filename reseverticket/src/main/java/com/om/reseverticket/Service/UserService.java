package com.om.reseverticket.Service;

import com.om.reseverticket.DOA.UserDOA;
import com.om.reseverticket.DTO.ChangePasswordDTO;
import com.om.reseverticket.DTO.UpdateUserDTO;
import com.om.reseverticket.Entity.UserPrinciple;
import com.om.reseverticket.Entity.Users;
import com.om.reseverticket.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;



    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public boolean SaveUser(Users user){
        if (userRepo.existsByUserName(user.getUserName()) || userRepo.existsByEmail(user.getEmail())) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);
        return true;

    }
    public Optional<Users> CheckUserName(String userName){
        return userRepo.findByUserName(userName);
    }

    public UserDOA getUserDetails(){
        String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        Users user = userRepo.findByUserName(loggedInUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + loggedInUsername));

        return new UserDOA(user);

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

    @Transactional
    public boolean updateProfile(UpdateUserDTO dto) {
        String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userRepo.findByUserName(loggedInUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + loggedInUsername));

        // Update email only if provided and not already taken by another user
        if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
            if (!dto.getEmail().equals(user.getEmail()) && userRepo.existsByEmail(dto.getEmail())) {
                throw new IllegalArgumentException("Email already taken by another account");
            }
            user.setEmail(dto.getEmail());
        }

        // Update phone number if provided
        if (dto.getPhnumber() != null && !dto.getPhnumber().isBlank()) {
            user.setPhNumber(dto.getPhnumber());
        }

        // Update name if provided
        if (dto.getName() != null && !dto.getName().isBlank()) {
            user.setName(dto.getName());
        }

        userRepo.save(user);
        return true;
    }

    @Transactional
    public boolean changePassword(ChangePasswordDTO dto) {
        String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userRepo.findByUserName(loggedInUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + loggedInUsername));

        // 1. Verify current password matches DB hash
        if (!passwordEncoder.matches(dto.getCurrentPassword(), user.getPassword())) {
            return false; // Wrong current password
        }

        // 2. Hash and save the new password
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepo.save(user);
        return true;
    }
}
