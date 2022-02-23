import java.util.Scanner;

public class nguyenTo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào số nguyên tố cần tìm:");
        int n =scanner.nextInt();
        int count= 0;
        int i=2;
        while (count<20) {
            if (soNguyenTo.Kt(i)) {
                count =count+1;
                System.out.println(i);
            }
            i=i+1;
        }
    }
}
