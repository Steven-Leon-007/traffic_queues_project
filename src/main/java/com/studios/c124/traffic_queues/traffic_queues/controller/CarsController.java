package com.studios.c124.traffic_queues.traffic_queues.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.studios.c124.traffic_queues.traffic_queues.service.CarsService;

@Controller
@RequestMapping()
public class CarsController {

    @Autowired
    private CarsService carsService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    
    @GetMapping("/test")
    public ModelAndView test(){
        carsService.initProccess();
        ModelAndView model = new ModelAndView("index");
        return model;
    }


}