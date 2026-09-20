package com.om.reseverticket.DOA;

import com.om.reseverticket.Entity.Users;

public class UserDOA {
    private final Users user;
    public UserDOA( Users user){
        this.user= user;
    }
    private String userName;
    private String name;
    private String Phnumber;
    private String email;


    public String getUserName() {
        return user.getUserName();
    }

    public String getName() {
        return user.getName();
    }

    public String getPhnumber() {
        return user.getPhNumber();
    }

    public String getEmail() {
        return user.getEmail();
    }
}
