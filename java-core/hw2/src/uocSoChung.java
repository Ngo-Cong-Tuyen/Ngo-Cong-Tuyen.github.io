import java.util.Scanner;

public class uocSoChung {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số a:");
        int a= scanner.nextInt();
        System.out.println("Nhập số b");
        int b= scanner.nextInt();
        if (a==0 && b==0) {
            System.out.println("Hai số không có ước chung lớn nhất");
        } else if (a==0) {
            System.out.println("Ước chung lớn nhất của hai số là: "+ Math.abs(b));
        } else if (b==0) {
            System.out.println("Ước chung lớn nhất của hai số là: " +Math.abs(a));
        } else {
            int i= Math.min(a,b);
            boolean isContinue= true;
            while (isContinue) {
                if (a%i==0 && b%i==0) {
                    System.out.println("Ước số chung lớn nhất của 2 số là: " + i);
                    isContinue= false;
                }
                i=i-1;
            }
        }
    }
}
