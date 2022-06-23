package com.example.student.service;

import com.example.student.exception.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
@Service
public class ColorService {
    public String randomColor(int type) {
       return switch (type){
           case 1 -> randomColorName();
           case 2 -> randomHexColor();
           case 3 -> randomRgbColor();
           default -> throw new BadRequestException("type ko hop le");
       };
    }

    public String randomColorName(){
        String[] colors = {"red","green","blue","yellow","pink"};
        Random rd = new Random();
        int index = rd.nextInt(colors.length);
        return colors[index];
    }

    public String randomHexColor(){
        Random random = new Random();

        // create a big random number - maximum is ffffff (hex) = 16777215 (dez)
        int nextInt = random.nextInt(0xffffff + 1);

        // format it as hexadecimal string (with hashtag and leading zeros)
        String color = String.format("#%06x", nextInt);
        return color;
    }

    public String randomRgbColor() {
        Random random= new Random();
        int R = random.nextInt(256);
        int G = random.nextInt(256);
        int B=  random.nextInt(256);
        String color = "RGB("+R+","+G+","+B+")";
        return color;
    }
}
