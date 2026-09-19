package com.om.reseverticket.Controller;

import com.om.reseverticket.Entity.Users;
import com.om.reseverticket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping ("/sign-up")

    public ResponseEntity<String> saveUser(@RequestBody Users user){
        if(userService.SaveUser(user)){
            return new ResponseEntity<>(user.getName()+" you have successfully registered!", HttpStatus.CREATED);
        }

        if(userService.getByUserName(user.getUserName()).isPresent()) {
            return new ResponseEntity<>("User Name " + user.getUserName() + " already exists please choose another!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Email "+user.getEmail()+" already exists please try another!", HttpStatus.CONFLICT);


    }
    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable Long userId){
        Optional<Users> user=userService.getById(userId);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/search/{userName}")
    public ResponseEntity<Users> getUserByUserName(@PathVariable String username){
        Optional<Users> user=userService.getByUserName(username);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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




}
