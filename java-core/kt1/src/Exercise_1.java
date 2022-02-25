import java.util.Scanner;

public class Exercise_1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Danh sách các hình được chọn:");
        System.out.println("1. Hình vuông.");
        System.out.println("2. Hình tam giác dạng 1.");
        System.out.println("3. Hình tam giác dạng 2.");
        System.out.println("Vui lòng chọn hình từ 1 đến 3:");
        int n=scanner.nextInt();
        switch (n){
            case 1:
                System.out.println("* * * *\n* * * *\n* * * *\n* * * *");
            case 2:
                System.out.println("*\n* *\n* * *\n* * * *");
            case 3:
                System.out.println(" *\n * *\n * * *\n* * * *");
            default:
                System.out.println("Lựa chọn không phù hợp.");
        }
    }
}
