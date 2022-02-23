import java.util.Scanner;

public class interestRate {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập số tiền gửi:");
        int principal= scanner.nextInt();
        System.out.println("nhập lãi suất ngân hàng:");
        double interestRate= scanner.nextDouble();
        System.out.println("Nhập số tháng cần gửi:");
        int n= scanner.nextInt();
        double simpleInterest= principal*interestRate*n/12+principal;
        System.out.printf("Tổng số tiền gửi trong %d tháng là: %.0f",n,simpleInterest);
    }
}

