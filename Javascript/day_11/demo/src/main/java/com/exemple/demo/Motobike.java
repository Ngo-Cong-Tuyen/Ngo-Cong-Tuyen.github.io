package com.exemple.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("motobike")
public class Motobike implements IVehicle{

    @Override
    public void move() {
        System.out.println("di cuyen bang xe may");
    }
}
