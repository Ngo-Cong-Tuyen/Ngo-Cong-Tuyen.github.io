package QuanLySanPham;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {

    protected static void getListProduct(ArrayList<Product> list){
        list.add(new Product("1", "Lamp", Category.HOUSEWARE, 15, 50000));
        list.add(new Product("2","Chair", Category.HOUSEWARE, 10, 75000));
        list.add(new Product("3","Bed", Category.HOUSEWARE, 3, 1000000));
        list.add(new Product("4", "Burger", Category.FOOD, 8, 35000));
        list.add(new Product("5", "Pizza", Category.FOOD, 2, 150000));
        list.add(new Product("6", "Coca-Cola", Category.FOOD, 13, 10000));
        list.add(new Product("7", "T-shirt", Category.FASHION, 7, 150000));
        list.add(new Product("8", "Pant", Category.FASHION, 3, 200000));
        list.add(new Product("9", "Castor", Category.FASHION, 4, 250000));
    }

    protected static void showList(ArrayList<Product> list) {
        System.out.println("Danh sách các sản phẩm là:");
        for (Product p : list) {
            System.out.println(p);
        }
    }

    protected static void findName(ArrayList<Product> list) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm cẩn tìm:");
        String name= scanner.nextLine();
        boolean check= true;
        for (Product p: list) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("Sản phẩm tìm được là:");
                System.out.println(p);
                check= false;
            }
        }
        if (check) {
            System.out.println("Không có sản phẩm cần tìm");
        }
    }

    protected static void findAmount(ArrayList<Product> list) {
        boolean check= true;
        System.out.println("Sản phẩm có số lượng <5 là:");
        for (Product p: list) {
            if (p.getAmount()<5) {
                System.out.println(p);
                check= false;
            }
        }
        if (check) {
            System.out.println("Không có sản phẩm cần tìm");
        }
    }

    protected static void Control(ArrayList<Product> list) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Nhập id sản phẩm cần tìm là:");
        String id= scanner.nextLine();
        boolean check= true;
        for (int i=0; i<list.size();i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.println("Sản phẩm tìm được là:");
                System.out.println(list.get(i));

                System.out.println("Bạn cần:");
                System.out.println("1.Xóa sản phẩm vừa tìm được");
                System.out.println("2.Cập nhật số lượng sản phẩm");
                System.out.println("3.Cập nhật giá bán của sản phẩm");
                System.out.println("0.Exit");
                boolean isContinue= true;
                while (isContinue){
                    System.out.println("Mời nhập");
                    int m= scanner.nextInt();
                    switch (m) {
                        case 1:
                            list.remove(i);
                            break;
                        case 2:
                            System.out.println("Số lượng sản phẩm mới là:");
                            int k= scanner.nextInt();
                            list.get(i).setAmount(k);
                            break;
                        case 3:
                            System.out.println("Giá bán mới là:");
                            long price= scanner.nextLong();
                            list.get(i).setPrice(price);
                            break;
                        case 0:
                            System.out.println("Exit");
                            isContinue=false;
                            break;
                        default:
                            System.out.println("Mời nhập lại!");
                    }
                }

            }
        }
        if (check) {
            System.out.println("Không có sản phẩm cần tìm");
        }

    }

    protected static void addNewProduct(ArrayList<Product> list){
        Scanner scanner=new Scanner(System.in);
        Product p= new Product("0","0",Category.FASHION,0,0);
        System.out.println("Bạn cần tạo đối tượng mới");
        System.out.println("Nhập id:");
        String id= scanner.nextLine();
        p.setId(id);
        System.out.println("Nhập tên:");
        String name= scanner.nextLine();
        System.out.println("Nhập loại sản phẩm:");
        String category=scanner.nextLine();
        p.setCategory(Category.valueOf(category));
        System.out.println("Nhập số lượng sản phẩm:");
        int amount= scanner.nextInt();
        p.setAmount(amount);
        System.out.println("Nhập giá sản phẩm:");
        long price= scanner.nextLong();
        p.setPrice(price);
        list.add(p);
    }

    protected static void checkPrice(ArrayList<Product> list) {
        System.out.println("Xem sản phẩm theo các mức giá:");
        System.out.println("1.Dưới 50.000");
        System.out.println("2.Từ 50.000 đến dưới 100.000");
        System.out.println("3.Từ 100.000 đến dưới 250.000");
        System.out.println("4.Trên 250.000");
        System.out.println("0.Exit");
        Scanner scanner=new Scanner(System.in);
        boolean isContinue =true;
        while (isContinue) {
            System.out.println("Mời nhập:");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Sản phẩm cần tìm là:");
                    for (Product p : list) {
                        if (p.getPrice() < 50000) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Sản phẩm cần tìm là:");
                    for (Product p : list) {
                        if (p.getPrice() >= 50000 && p.getPrice() < 100000) {
                            System.out.println(p);
                        }
                    }
                case 3:
                    System.out.println("Sản phẩm cần tìm là:");
                    for (Product p : list) {
                        if (p.getPrice() >= 100000 && p.getPrice() < 250000) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Sản phẩm cần tìm là:");
                    for (Product p : list) {
                        if (p.getPrice() >= 250000) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exit");
                    isContinue = false;
                    break;
                default:
                    System.out.println("Lựa chọn không phù hợp!");
            }
        }
    }

    protected static void filterListByCategory(ArrayList<Product> list){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập loại sản phẩm cần tìm:");
        Category category= Category.valueOf(sc.nextLine());
        System.out.println("Danh sách cần tìm là:");
        for (Product p:list){
            if (p.getCategory().equals(category)) {
                System.out.println(p);
            }
        }
    }
}
