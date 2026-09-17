package com.om.reseverticket.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "SMPO_USERS")
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(
            name = "user_seq_gen",
            sequenceName = "USER_SEQUENCE",
            allocationSize = 1
    )
    @Column(name = "user_id")
    private Long userId;
    @Column(name="user_name")
    private String userName;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private Character gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "phnumber")
    private String phNumber;
    @Column(name="email")
    private String email;
    @Column(name="creation_date")
    private LocalDate creationDate;

    public Users(){

    }
    @PrePersist
    public void prePersist() {
        if (this.creationDate == null) {
            this.creationDate = LocalDate.now();
        }
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
