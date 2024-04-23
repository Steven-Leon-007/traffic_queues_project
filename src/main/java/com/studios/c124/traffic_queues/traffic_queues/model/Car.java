package com.studios.c124.traffic_queues.traffic_queues.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

    private int[] color;
    private int position;
    private String colorHEX;

    public Car(int[] color) {
        this.position = 0;
        if (color.length != 3) {
            throw new IllegalArgumentException("Only three values allowed");
        }
        this.color = color;
    }

    @Override
    public String toString() {
        return "color: "+"["+color[0]+", "+color[1]+", "+color[2]+"]"+"\nposition: "+position;
    }
}
