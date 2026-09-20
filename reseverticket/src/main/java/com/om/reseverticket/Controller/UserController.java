package com.om.reseverticket.Controller;

import com.om.reseverticket.DOA.UserDOA;
import com.om.reseverticket.DTO.ChangePasswordDTO;
import com.om.reseverticket.DTO.UpdateUserDTO;
import com.om.reseverticket.DTO.UserLoginDTO;
import com.om.reseverticket.Entity.UserPrinciple;
import com.om.reseverticket.Entity.Users;
import com.om.reseverticket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping ("/sign-up")

    public ResponseEntity<String> saveUser(@RequestBody Users user){
        if(userService.SaveUser(user)){
            return new ResponseEntity<>(user.getName()+" you have successfully registered!", HttpStatus.CREATED);

        }

        if(userService.CheckUserName(user.getUserName()).isPresent()) {
            return new ResponseEntity<>("User Name " + user.getUserName() + " already exists please choose another!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Email "+user.getEmail()+" already exists please try another!", HttpStatus.CONFLICT);


    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO loginRequest) {
        try {
            org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(
                    new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                            loginRequest.getUserName(),
                            loginRequest.getPassword()
                    )
            );

            if (authentication.isAuthenticated()) {
                return new ResponseEntity<>("Login successful!", HttpStatus.OK);

            }
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);

        } catch (org.springframework.security.core.AuthenticationException e) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/details")
    public UserDOA getUserByUserName(){
        return userService.getUserDetails();

    }
    @DeleteMapping("/deactivate/id/{userId}")
    public ResponseEntity<String> deactiveUser(@PathVariable("userId") Long userId){
        if(userService.deactivateUser(userId)){
            return new ResponseEntity<>("See you again soon", HttpStatus.OK);
        }
        return new ResponseEntity<>("userId not exists!",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/deactivate/username/{userName}")
    public ResponseEntity<String> deactiveUser(@PathVariable("userName") String userName){
        if(userService.deactivateUser(userName)){
            return new ResponseEntity<>("See you again soon", HttpStatus.OK);
        }
        return new ResponseEntity<>("userId not exists!",HttpStatus.NOT_FOUND);
    }
    @PatchMapping("/profile")
    public ResponseEntity<String> updateProfile(@RequestBody UpdateUserDTO profileDTO) {
        try {
            userService.updateProfile(profileDTO);
            return ResponseEntity.ok("Profile updated successfully!");
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PatchMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO passwordDTO) {
        boolean isUpdated = userService.changePassword(passwordDTO);
        if (!isUpdated) {
            return new ResponseEntity<>("Current password does not match", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("Password changed successfully!");
    }




}
