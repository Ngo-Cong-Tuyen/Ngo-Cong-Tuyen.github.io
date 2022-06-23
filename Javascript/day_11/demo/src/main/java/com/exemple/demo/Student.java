package com.exemple.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;

//    @Autowired
//    @Qualifier("bus")
//    private IVehicle vehicle;
//
//    public Student(IVehicle vehicle) {
//        this.vehicle = vehicle;
//    }
}
