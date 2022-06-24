package com.example.bmi.service;

import org.springframework.stereotype.Service;

@Service
public class BmiService {
    public String checkBmi(float height, float weight ){
        float BMI = weight/(height*height);
        if (BMI < 18.5)
        {
            return "Thiếu cân";
        }
        else if (BMI >= 18.5 && BMI <= 24.9)
        {
            return "Bình thường";
        }
        else if (BMI >= 25 && BMI <= 29.9)
        {
            return "Thừa cân";
        }
        else
        {
            return "Béo phì";
        }
    }
}
