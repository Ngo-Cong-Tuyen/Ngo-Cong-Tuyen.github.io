import java.util.Scanner;

public class Thang {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("nhap thang can kiem tra:");
        int i=scanner.nextInt();
        switch (i){
            case 1,3,5 :
                System.out.println("co 31 ngay");
                break;
            default:
                System.out.println("nhap sai");
        }
    }
}
