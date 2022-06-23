package com.exemple.demo;

import org.springframework.stereotype.Component;

@Component("bus")

public class Bus implements IVehicle{

    @Override
    public void move() {
        System.out.println("di chyen bang xe buyt");
    }
}
