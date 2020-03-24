package com.iopent.parking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "parking")
public class Parking extends BaseEntity {

    @Column(name = "capacity")
    private Integer capacity;
}