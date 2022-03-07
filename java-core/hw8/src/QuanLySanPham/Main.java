package QuanLySanPham;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> listProduct= new ArrayList<>();
        ProductController.getListProduct(listProduct);
        ProductController.showList(listProduct);
        ProductController.Control(listProduct);
        System.out.println("List sau khi chỉnh sửa là:");
        ProductController.showList(listProduct);
        ProductController.addNewProduct(listProduct);
        System.out.println("List mới là:");
        ProductController.showList(listProduct);
        ProductController.checkPrice(listProduct);
        ProductController.filterListByCategory(listProduct);

    }
}
