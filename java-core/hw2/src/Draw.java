import java.util.Scanner;

public class Draw {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Menu hình vẽ:");
        System.out.println("1. Hình tam giác");
        System.out.println("2. Hình chữ nhật");
        System.out.println("3. Hình vuông");
        System.out.println("0. Exit");
        int choice=-1;
        do {
            System.out.println("Nhập hình bạn muốn vẽ:");
            choice= scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("* * * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * *");
                    System.out.println("* * *");
                    System.out.println("* * ");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    break;
                case 3:
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    System.out.println("* * * * *");
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Lựa chọn chưa phù hợp");


            }
        } while (choice!=0);

    }
}
