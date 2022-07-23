package com.example.jobhunt.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {
    public static String money(int salary){
        return (NumberFormat.getCurrencyInstance(new Locale("vi", "VN"))
                .format(salary));
    }

}
