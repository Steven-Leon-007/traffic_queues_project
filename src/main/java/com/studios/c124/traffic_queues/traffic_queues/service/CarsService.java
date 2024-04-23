package com.studios.c124.traffic_queues.traffic_queues.service;

import java.util.LinkedList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.studios.c124.traffic_queues.traffic_queues.model.Car;

@Service
public class CarsService {

    private LinkedList<Car> queue;
    private int defaultMove;

    public CarsService(@Value("${movement_queue}") int defaultMove) {
        this.defaultMove = defaultMove;
        this.queue = new LinkedList<Car>();
    }


    public LinkedList<Car> fillQueue(int numCars) {
        for (int i = 0; i < numCars; i++) {
            Random random = new Random();
            int[] colors = { random.nextInt(256), random.nextInt(256), random.nextInt(256) };
            Car car = new Car(colors);
            car.setColorHEX(String.format("#%02x%02x%02x", colors[0], colors[1], colors[2]));
            addCar(car);
        }
        initCarsPosition();
        return queue;
    }

    private LinkedList<Car> initCarsPosition() {
        for (int i = 0; i < queue.size(); i++) {
            queue.get(i).setPosition(defaultMove * (queue.size() - i));            
        }
        return queue;
    }
    
    public void addCar(Car car) {
        this.queue.add(car);
    }

    public LinkedList<Car> deleteFirstCar() {                
        if (!queue.isEmpty()) {
            this.queue.removeFirst();    
            return this.queue;
        }
        return this.queue;
    }
}