package com.example.coron.util;



import com.example.coron.dto.BlogDto;
import com.example.coron.dto.CartInfo;
import com.example.coron.dto.ProductDto;
import com.example.coron.entity.Amount;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Utils {

    // Format money Vietnam
    public static String money(int salary){
        return (NumberFormat.getCurrencyInstance(new Locale("vi", "VN"))
                .format(salary));
    }

    public static String generateCategoryString(List<ProductDto.CategoryDto> categories) {
        if(categories.size() == 0) {
            return "";
        }

        // Lấy ra Listname của Category
        List<String> categoriesName = categories.stream().map(ProductDto.CategoryDto::getName).toList();

        // Chuyển List -> Array
        String[] itemsArray = new String[categoriesName.size()];
        itemsArray = categoriesName.toArray(itemsArray);

        // Join Array -> String
        return String.join(", ", itemsArray);
    }

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

    public static String renderBlogContent(String content){
        return content.substring(0,200)+ "...";
    }

    public static Integer totalProducts(List<ProductDto.AmountDto> amounts){
        Integer total=0;
        for(ProductDto.AmountDto amount: amounts){
            total += amount.getQuantity();
        }
        return total;
    }

    public static String renderCart(List<CartInfo> carts){
        String cartInfo;
        int sum =0;
        for (CartInfo cart: carts){
            sum += cart.getPrice();
        }
        cartInfo = carts.size()+ " items - " + money(sum);
        return cartInfo;
    }
}
