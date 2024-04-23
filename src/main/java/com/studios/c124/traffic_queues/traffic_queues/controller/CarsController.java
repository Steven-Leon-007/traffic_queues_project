package com.studios.c124.traffic_queues.traffic_queues.controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.studios.c124.traffic_queues.traffic_queues.model.Car;
import com.studios.c124.traffic_queues.traffic_queues.service.CarsService;

@Controller
@RequestMapping()
public class CarsController {

    @Autowired
    private CarsService carsService;
    private LinkedList<Car> carsQueue;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("cars", carsQueue);
        return model;
    }

    @PostMapping("/add")
    public String test(@RequestParam int amount){
        carsQueue = carsService.fillQueue(amount);
        return "redirect:/";
    }


}