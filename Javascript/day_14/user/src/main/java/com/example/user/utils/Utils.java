package com.example.user.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Utils {
    // Lay extension cua file
    // image01.png ->png
    // image02.jpg ->jpg
    public static String getFileExtension(String fileName){
        int lastIndexOf = fileName.lastIndexOf('.');
        if (lastIndexOf==-1){
            return "";
        }
        return fileName.substring(lastIndexOf+1);

    }


    //Kiem tra extensipon co hop le ko
    public static boolean checkFileExtension(String fileExtension){
        List<String> fileExtensions = Arrays.asList("png","jpg","jpeg");
        return fileExtensions.contains(fileExtension);
    }
}
