package com.studios.c124.traffic_queues.traffic_queues.service;

import java.util.LinkedList;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.studios.c124.traffic_queues.traffic_queues.model.Car;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class CarsService {

    private int numCars;
    private LinkedList<Car> queue;
    private int defaultMove = 5;

    public CarsService() {
        this.numCars = 5;
        this.queue = new LinkedList<Car>();
        initProccess();
    }

    public void initProccess() {
        fillQueue();
        initCarsPosition();
    }

    private void fillQueue() {
        for (int i = 0; i < numCars; i++) {
            Random random = new Random();
            int[] colors = { random.nextInt(256), random.nextInt(256), random.nextInt(256) };
            addCar(new Car(colors));
        }
    }

    private LinkedList<Car> initCarsPosition() {
        for (int i = 0; i < queue.size(); i++) {
            queue.get(i).setPosition(queue.get(i).getPosition() + (defaultMove * (queue.size() - i)));
        }
        return queue;
    }

    public void addCar(Car car) {
        this.queue.add(car);
    }
}