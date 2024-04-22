package com.studios.c124.traffic_queues.traffic_queues.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    
    private String id;    
    private int[] color;

    public Car(String id, int[] color) {
        this.id = id;
        if (color.length != 3) {
            throw new IllegalArgumentException("Only three values allowed");
        }
        this.color = color;
    }
}
