package com.example.coron.util;

import com.example.coron.dto.ReviewInfo;
import com.example.coron.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UtilsBackend {
    public  List<Integer> changeStringToList(String str){
        String[] items = str.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (String i: items) {
            list.add(Integer.parseInt(i));
        }
        return list;
    }

    public double calculateAverageRating(List<ReviewInfo> reviews){
        int sum =0;
        for (ReviewInfo review: reviews) {
            sum+= review.getRating();
        }
        if (reviews.size()==0) return 0;
        double average= sum/ reviews.size();
        average= Math.round(average*10)/10;
        return average;
    }
}
