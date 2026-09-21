package com.om.reseverticket.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class UserPrinciple implements UserDetails {
    private final Users user;
    public UserPrinciple(Users user){
        this.user= user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Returns the actual DB role (e.g., "ROLE_ADMIN" or "ROLE_USER")
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }
}
