import java.util.Scanner;

public class soNguyenTo {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập số cần kiểm tra:");
        double n=sc.nextDouble();
        int i=2;
        int k=0;
        while (i <= Math.sqrt(n)) {
            if (n % i== 0) {
                k=k+1;
                System.out.println(i);
            }
            i=i+1;
        }
        if (k==0 && n>1) {
            System.out.println("Số trên là số nguyên tố");
        } else {
            System.out.println("Số trên không phải là số nguyên tố");
        }
    }
    public static boolean Kt (int n) {
        int i=2;
        int k=0;
        Boolean bl;
        while (i <= Math.sqrt(n)) {
            if (n % i== 0) {
                k=k+1;
            }
            i=i+1;
        }
        if (k==0 && n>1) {
            bl=true;
        } else {
            bl=false;
        }
        return bl;
    }
}
