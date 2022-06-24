package com.example.bmi.controller;

import com.example.bmi.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BmiController {

    @Autowired
    private BmiService bmiService;
//  http://localhost:8080/bmi?height=${height}&weight=${weight}
    @GetMapping("/bmi")
    public String getResult(@RequestParam float height, @RequestParam float weight){
        return bmiService.checkBmi(height,weight);
    }

}
