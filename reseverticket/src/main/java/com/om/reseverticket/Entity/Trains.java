package com.om.reseverticket.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "SMPO_TRAINS")
public class Trains {
    @Id
    @Column(name = "TRAIN_NO",nullable = false)
    private Long train_no;
    @Column(name = "TRAIN_NAME",nullable = false)
    private String train_name;
    @Column(name = "TRAIN_TYPE",nullable = false)
    private String train_type;
    @Column(name = "TOTAL_COACHES",nullable = false)
    private Integer total_coaches;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ROUTE_ID")
    @JsonBackReference
    private Routes route;
    public Trains(){

    }

    public Long getTrain_no() {
        return train_no;
    }

    public void setTrain_no(Long train_no) {
        this.train_no = train_no;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getTrain_type() {
        return train_type;
    }

    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }

    public Integer getTotal_coaches() {
        return total_coaches;
    }

    public void setTotal_coaches(Integer total_coaches) {
        this.total_coaches = total_coaches;
    }

    public Routes getRoute_id() {
        return route;
    }

    public void setRoute_id(Routes route_id) {
        this.route = route_id;
    }
}
