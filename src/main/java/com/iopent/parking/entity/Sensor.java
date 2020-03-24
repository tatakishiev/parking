package com.iopent.parking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity(name = "sensors")
public class Sensor extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;

    @Column(name = "is_free")
    private Boolean isFree;
}
